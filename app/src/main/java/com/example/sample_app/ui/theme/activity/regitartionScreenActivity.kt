package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sample_app.databinding.ActivityRegitartionScreenBinding


class regitartionScreenActivity : ComponentActivity() {

    lateinit var binding: ActivityRegitartionScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityRegitartionScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {

            val name = binding.name.text.toString()

            binding.belowtxt.text = "Registration Successful " + "$name"

        }
    }
}