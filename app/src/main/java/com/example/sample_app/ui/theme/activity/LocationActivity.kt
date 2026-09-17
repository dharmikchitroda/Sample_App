package com.example.sample_app.ui.theme.activity

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.sample_app.databinding.ActivityLocationBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import java.util.Date
import java.util.Locale

class LocationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLocationBinding
    private lateinit var locationCallback: LocationCallback
    private lateinit var fusedlocationClient: FusedLocationProviderClient


    @SuppressLint("MissingPermission")
    private fun getCurrentLocation() {

        val locationRequest = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY,
            3000
        ).build()

        locationCallback = object : LocationCallback() {

            override fun onLocationResult(result: LocationResult) {

                val location = result.lastLocation

                if (location != null) {

                    var latitude = location.latitude.toString()
                    var longitude = location.longitude.toString()


                    binding.tvLatitude.text = latitude

                    binding.tvLongitude.text = longitude

                    val geocoder = Geocoder(this@LocationActivity, Locale.getDefault())

                    val address =
                        geocoder.getFromLocation(latitude.toDouble(), longitude.toDouble(), 1)
                            ?.firstOrNull()

                    binding.tvLocation.text =
                        "${address?.locality}, ${address?.adminArea} ,${address?.countryName}"

                }


            }
        }

        fusedlocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )

        // for last location
        fusedlocationClient.lastLocation.addOnSuccessListener { location ->

            if (location != null) {

                val time = Date(location.time)
                binding.tvTime.text = time.toString()

            } else {
                Log.d("location123", "Location is null")
            }


        }
    }

    private var locationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->

        val fineGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
        val coarseGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true

        if (fineGranted || coarseGranted) {
            checkLocationPermission()
        }
    }

    private fun checkLocationPermission() {

        val fineGranted = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val coarseGranted = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!fineGranted && !coarseGranted) {

            locationPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )

        } else {

            val locationManager = getSystemService(LocationManager::class.java)

            val isLocationEnabled = locationManager.isLocationEnabled


            if (isLocationEnabled) {
                getCurrentLocation()
            } else {
                // gps is off user move setting page
                AlertDialog.Builder(this)
                    .setTitle("Location Required")
                    .setMessage("Please enable Location to continue.")
                    .setPositiveButton("Enable") { _, _ ->
                        startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                    }
//                    .setNegativeButton("cancel",null)
                    .show()

            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedlocationClient = LocationServices.getFusedLocationProviderClient(this)

        checkLocationPermission()

    }

    override fun onStop() {
        super.onStop()
        fusedlocationClient.removeLocationUpdates(locationCallback)
    }
}