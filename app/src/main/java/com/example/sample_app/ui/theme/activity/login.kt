package com.example.sample_app.ui.theme.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sample_app.MainActivity
import com.example.sample_app.databinding.ActivityTask2Binding

import android.widget.Toast

class task2 : ComponentActivity() {

    lateinit var binding: ActivityTask2Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityTask2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val mail = binding.etEmail.text.toString().trim()

            if (name == "dharmik") {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid credentials. Use name: dharmik", Toast.LENGTH_SHORT).show()
            }
        }
    }
}