package com.example.sample_app.ui.theme.activity

import android.R.attr.delay
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.sample_app.MainActivity
import com.example.sample_app.databinding.ActivityTask2Binding
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class task2 : ComponentActivity() {

    lateinit var binding: ActivityTask2Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityTask2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        val handler = Handler(Looper.getMainLooper())

        binding.btnSignup.setOnClickListener {

            val name = binding.etName.text.toString()
            val mail = binding.etEmail.text.toString()

        val asda=     lifecycleScope.launch {
                Toast.makeText(this@task2, "Started", Toast.LENGTH_SHORT).show()

                val result = async {
                    delay(2000)
                    "Data Loaded"
                }
                val data = result.await()

                    Toast.makeText(this@task2, data, Toast.LENGTH_SHORT).show()
            }

            if (name == "dharmik") {

                var intent = Intent(this, MainActivity::class.java)

                startActivity(intent)
            }

        }

    }
}