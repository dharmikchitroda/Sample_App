package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.sample_app.databinding.ActivitySignupBinding
import com.example.sample_app.ui.theme.model.request.LoginRequestdata
import com.example.sample_app.ui.theme.reposetry.repoRetrofit
import com.example.sample_app.ui.theme.viewmodels.MiniAppViewmodel
import com.example.sample_app.ui.theme.viewmodels.RetrofitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class signupActivity : ComponentActivity() {
    private val viewModel: RetrofitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.hintview.text = "name : emilys & pass : emilyspass"

        // Response observe
        viewModel.loginResponse.observe(this) { response ->

            binding.hintview.text =
                response.toString()
        }

        binding.btnSignup.setOnClickListener {

            val username = binding.etName.text.toString()
            val password = binding.etEmail.text.toString()

            val request = LoginRequestdata(
                username = username,
                password = password
            )

            viewModel.login(request)
        }
    }
}