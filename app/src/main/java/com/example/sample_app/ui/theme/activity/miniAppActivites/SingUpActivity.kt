package com.example.sample_app.ui.theme.activity.miniAppActivites

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.sample_app.R
import com.example.sample_app.databinding.ActivityLoginInBinding
import com.example.sample_app.databinding.ActivitySingUpBinding
import com.example.sample_app.ui.theme.viewmodels.MiniAppViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlin.getValue

@AndroidEntryPoint
class SingUpActivity : ComponentActivity() {

    lateinit var binding: ActivitySingUpBinding

    private val viewModel: MiniAppViewmodel by viewModels()

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val mail = binding.etEmail.text.toString()
            val pass = binding.etPassword.text.toString()

            binding.tilEmail.error = null
            binding.tilPassword.error = null

            if (mail.isBlank()) {
                binding.tilEmail.error = "Please fill this fields"

            } else if (pass.isBlank()) {
                binding.tilPassword.error = "Please fill this fields"

            }

            val intent = Intent(this, LoginInActivity::class.java).apply {
                putExtra("mail", mail)
                putExtra("pass", pass)
            }
            startActivity(intent)


        }

        lifecycleScope.launch(Dispatchers.Main) {
            val reply = getusername().toList()
            Log.d("autocollect", "$reply")

        }
    }

    private suspend fun getusername(): Flow<String> = flow {
        emit(getuser(1))
        emit(getuser(2))
        emit(getuser(3))
        emit(getuser(4))
    }

    private suspend fun getuser(id: Int): String {
        delay(2000)
        return "User$id"
    }
}