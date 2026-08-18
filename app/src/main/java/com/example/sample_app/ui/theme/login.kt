package com.example.sample_app.ui.theme

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.sample_app.MainActivity
import com.example.sample_app.databinding.ActivityTask2Binding

class task2 : ComponentActivity() {

    lateinit var binding: ActivityTask2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTask2Binding.inflate(layoutInflater)



        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {

          val name = binding.etName.text.toString()
        val mail = binding.etEmail.text.toString()


            if ( name=="dharmik") {

                var intent = Intent(this, MainActivity::class.java)

                startActivity(intent)
            }

        }

    }
}