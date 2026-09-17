package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sample_app.databinding.ActivityInfoBinding
import com.example.sample_app.ui.theme.utils.IntentKeys


class infostudentActivity : ComponentActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvName.text = "Name : " + intent.getStringExtra(IntentKeys.student_name).toString()
        binding.tvEmail.text = "Email : " + intent.getStringExtra(IntentKeys.student_email).toString()
        binding.tvNumber.text = "Number : " + intent.getStringExtra(IntentKeys.student_mobile).toString()
    }
}