package com.example.sample_app.ui.theme.activity

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sample_app.MyBroadcastReciver
import com.example.sample_app.R
import com.example.sample_app.databinding.ActivityBroadCastBinding

class BroadCastActivity : AppCompatActivity() {
    lateinit var binding: ActivityBroadCastBinding
    lateinit var BroadcastReciver: MyBroadcastReciver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBroadCastBinding.inflate(layoutInflater)
        setContentView(binding.root)
        BroadcastReciver = MyBroadcastReciver()

        binding.btnbroadcast.setOnClickListener {

            val intent = Intent("com.example.MY_CUSTOM_BROADCAST")
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }

    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onStart() {
//        var intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
//        var intentFilter = IntentFilter("com.example.MY_CUSTOM_BROADCAST")
        var intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction("com.example.MY_CUSTOM_BROADCAST")
        }

        registerReceiver(BroadcastReciver, intentFilter, RECEIVER_NOT_EXPORTED)

        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(BroadcastReciver)
    }
}