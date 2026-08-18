package com.example.sample_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sample_app.databinding.ActivityMainBinding
import com.example.sample_app.ui.theme.activity.ApiOptbtnActivity
import com.example.sample_app.ui.theme.activity.KotlineBasicActivity
import com.example.sample_app.ui.theme.activity.LifeCycleActivity
import com.example.sample_app.ui.theme.activity.livedataActivity
import com.example.sample_app.ui.theme.activity.recyleviewActivity
import com.example.sample_app.ui.theme.activity.registrationLocalActivity
import com.example.sample_app.ui.theme.activity.signupActivity
import com.example.sample_app.ui.theme.activity.regitartionScreenActivity
import com.example.sample_app.ui.theme.task2

class MainActivity : ComponentActivity() {

lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate( layoutInflater)

        setContentView(binding.root)

        // task 1 btn clicked
        binding.button1.setOnClickListener {

            val intent = Intent(this , regitartionScreenActivity ::class.java)
            startActivity(intent)

        }

        // task 2 btn clicked
        binding.button2.setOnClickListener {

            val intent = Intent(this , task2::class.java)
            startActivity(intent)

        }

        binding.signup.setOnClickListener {
            val intent = Intent(this , signupActivity::class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            val intent = Intent(this , livedataActivity::class.java)
            startActivity(intent)
        }

        binding.recButton.setOnClickListener {
            val intent = Intent(this , recyleviewActivity::class.java)
            startActivity(intent)
        }
        binding.localdataButton.setOnClickListener {
            val intent = Intent(this , registrationLocalActivity::class.java)
            startActivity(intent)
        }

        binding.ApiButton.setOnClickListener {
            val intent = Intent(this , ApiOptbtnActivity::class.java)
            startActivity(intent)
        }

        binding.btnlifecycle.setOnClickListener {
            val intent = Intent(this , LifeCycleActivity::class.java)
            startActivity(intent)
        }
        binding.btnKotlinBasic.setOnClickListener {
            val intent = Intent(this , KotlineBasicActivity::class.java)
            startActivity(intent)
        }



    }




}