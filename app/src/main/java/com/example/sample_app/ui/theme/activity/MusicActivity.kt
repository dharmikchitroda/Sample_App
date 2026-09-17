package com.example.sample_app.ui.theme.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sample_app.R
import com.example.sample_app.databinding.ActivityMusicBinding
import com.example.sample_app.ui.theme.Services.MusicService

class MusicActivity : AppCompatActivity() {

    lateinit var binding: ActivityMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMusicBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnstartmusic.setOnClickListener {

            val serviceintent = Intent(this, MusicService::class.java)
            ContextCompat.startForegroundService(this, serviceintent)

        }
        binding.btnstopmusic.setOnClickListener {

            val serviceintent = Intent(this, MusicService::class.java)

            this.stopService(serviceintent)
        }

    }
}