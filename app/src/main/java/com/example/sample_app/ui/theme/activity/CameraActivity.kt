package com.example.sample_app.ui.theme.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sample_app.MainActivity
import com.example.sample_app.R
import com.example.sample_app.databinding.ActivityCameraBinding
import com.example.sample_app.ui.theme.utils.IntentKeys
import java.io.File
import androidx.core.net.toUri

class CameraActivity : AppCompatActivity() {

    lateinit var binding: ActivityCameraBinding
    lateinit var uri: Uri
    private val pref by lazy { getSharedPreferences("cam_prefs", MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)

        setContentView(binding.root)

    val onBackPressedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            val intent = Intent(this@CameraActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        val Cameralauncher = registerForActivityResult(
            ActivityResultContracts.TakePicture()
        ) { sucess ->
            if (sucess) {
                binding.imageView.setImageURI(uri)
                  } else {
            }
        }

        val launcher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isgranted ->
            if (isgranted) {
                Log.d("cameraresult", "$isgranted")
                opencamera(Cameralauncher)
            } else {
                pref.edit().putBoolean("has_asked_camera", true).apply()

                if (!shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    // Permanently denied — show settings dialog
                    showSettingsDialog()
                } else {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }

        binding.btnopncamera.setOnClickListener {

         val haspermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

            when {
                haspermission -> opencamera(Cameralauncher)

                shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                    // denied once — system will show popup again
                    launcher.launch(Manifest.permission.CAMERA)
                }
                pref.getBoolean("has_asked_camera", false) -> {
                    // asked before, rationale is now false → permanently denied, no popup will show
                    showSettingsDialog()
                }
                else -> {
                    // very first time ever — no popup shown before
                    launcher.launch(Manifest.permission.CAMERA)
                }
            }
        }
    }
    fun opencamera ( launcher : ActivityResultLauncher<Uri>){
        val file = File(cacheDir, "Photo.jpg")
        // that uri set as image location after taken by camera
        uri = FileProvider.getUriForFile(
            this,
            "${packageName}.fileprovider",
            file
        )

        launcher.launch(uri)
    }

 fun showSettingsDialog() {
    androidx.appcompat.app.AlertDialog.Builder(this)
        .setTitle("Camera Permission Needed")
        .setMessage("You denied camera permission twice. Please enable it manually from Settings.")
        .setCancelable(false)
        .setPositiveButton("Go to Settings") { _, _ ->
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS ,
                "package:$packageName".toUri())
            startActivity(intent)
                finish()
        }
        .setNegativeButton("Cancel") { _, _ ->
            startActivity(Intent(this, MainActivity::class.java))
        }
        .show()
    }
}