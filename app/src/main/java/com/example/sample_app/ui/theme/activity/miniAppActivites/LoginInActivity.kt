package com.example.sample_app.ui.theme.activity.miniAppActivites

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.sample_app.databinding.ActivityCommonUiBinding
import com.example.sample_app.databinding.ActivityLoginInBinding
import com.example.sample_app.ui.theme.viewmodels.MiniAppViewmodel

class LoginInActivity : ComponentActivity() {

    lateinit var binding : ActivityLoginInBinding
    val viewmodel: MiniAppViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mail = intent.getStringExtra("mail")
        val pass = intent.getStringExtra("pass")

        binding.button.setOnClickListener {

            val mail = binding.etEmail.text.toString()
            val pass = binding.etPassword.text.toString()

            binding.tilEmail.error = null
            binding.tilPassword.error = null

            if (mail.isBlank()) {
                binding.tilEmail.error = "Please fill this fields"

            } else if (pass.isBlank()) {
                binding.tilPassword.error = "Please fill this fields"

            } else if (mail == mail && pass == pass) {



            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()

            }

            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,  CommonUiActivity::class.java)
            startActivity(intent)

        }

        binding.clickabletv.setOnClickListener {
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }
    }
}