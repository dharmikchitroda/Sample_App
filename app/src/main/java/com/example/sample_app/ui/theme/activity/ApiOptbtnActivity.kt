package com.example.sample_app.ui.theme.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sample_app.databinding.ActivityApiOptbtnBinding

class ApiOptbtnActivity : ComponentActivity() {

    private lateinit var binding: ActivityApiOptbtnBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityApiOptbtnBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getBtn.setOnClickListener {
            val intent = Intent(this, recyleviewActivity::class.java)
            startActivity(intent)
        }

        binding.postBtn.setOnClickListener {
            val intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
        }
    }
}