package com.example.sample_app.ui.theme.activity

import android.Manifest
import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.os.Looper
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresPermission
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.sample_app.ui.theme.Services.NewService
import com.example.sample_app.databinding.ActivityServiceBinding
import com.example.sample_app.ui.theme.Services.LocationService
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import kotlinx.serialization.descriptors.StructureKind

class ServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServiceBinding
    private lateinit var myService: NewService
    private var isBound = false

    // for location
    private lateinit var fusedlocationclient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    @SuppressLint("MissingPermission")
    private fun fetchcurrentlocatio() {

        val locationRequest = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY,
            2000
        ).build()

        locationCallback = object : LocationCallback() {

            override fun onLocationResult(result: LocationResult) {

                val location = result.lastLocation

                binding.tvLatitude.text = location?.latitude.toString()
                binding.tvLongitude.text = location?.longitude.toString()

            }
        }

        fusedlocationclient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    // location permission popup
    private var Locationpopuppermission = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permission ->

        val allowfinelocation = permission[Manifest.permission.ACCESS_FINE_LOCATION] == true
        val allowcoarselocation = permission[Manifest.permission.ACCESS_COARSE_LOCATION] == true

        if (allowfinelocation || allowcoarselocation) {
            asknotificationPermission()
        }
    }

    // notification permission popup
    val notificationpopuppermission = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {

            fetchcurrentlocatio()
            // permission mil gayi,task run
            ContextCompat.startForegroundService(this, Intent(this, LocationService::class.java))
        } else {
            // user ne deny kiya
        }
    }

    private fun asknotificationPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                fetchcurrentlocatio()
                ContextCompat.startForegroundService(
                    this, Intent(this, LocationService::class.java)
                )
            }
            // show pop-up
            else {
                notificationpopuppermission.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }

    }

    private fun checkruntimepermission() {

        val ENANBLE_COARSE: Boolean = ContextCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val ENANBLE_FINE: Boolean = ContextCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED


        if (ENANBLE_COARSE || ENANBLE_FINE) {
            asknotificationPermission()
        } else {

            Locationpopuppermission.launch(
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            )

        }

    }

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(
            name: ComponentName?, service: IBinder?
        ) {

            //  IBinder given by Android, that we convert our LocalBinder
            val binder = service as NewService.LocalBinder

            // actual NewService object found
            myService = binder.getService()

            // connection is done ?
            isBound = true

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        fusedlocationclient = LocationServices.getFusedLocationProviderClient(this)

        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceIntent = Intent(this, NewService::class.java)


        // normal service`
        bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE)

        binding.btnStart.setOnClickListener {

            if (isBound) {

                myService.showMessage()
            }
            startService(serviceIntent)

        }
        binding.btnStop.setOnClickListener {

            if (isBound) {

                unbindService(connection)
                isBound = false
            }
            stopService(serviceIntent)
        }
        binding.btnStartLocation.setOnClickListener {
            checkruntimepermission()
        }
        binding.btnStoplocation.setOnClickListener {

            stopService(Intent(this, LocationService::class.java))

            fusedlocationclient.removeLocationUpdates(locationCallback)
        }
    }

    override fun onStart() {
        super.onStart()

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fetchcurrentlocatio()
        }
    }

}

