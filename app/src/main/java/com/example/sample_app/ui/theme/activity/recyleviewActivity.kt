package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sample_app.databinding.ActivityRecyleviewBinding
import com.example.sample_app.ui.theme.Adapter.SimpleAdapter
import com.example.sample_app.ui.theme.viewmodels.RecylerViewViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

// oop used here : extend cardclickinterface interface without constructor

@AndroidEntryPoint
class recyleviewActivity : ComponentActivity() {

    private lateinit var binding: ActivityRecyleviewBinding
    private val viewModel: RecylerViewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyleviewBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.recview.layoutManager = LinearLayoutManager(this)


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    when (state) {
                        is RecylerViewViewModel.ApiResult.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }

                        is RecylerViewViewModel.ApiResult.Success -> {

                            val adapter = SimpleAdapter(dataset = state.data)
                            binding.recview.adapter = adapter

                            binding.progressBar.visibility = View.GONE
                        }

                        is RecylerViewViewModel.ApiResult.Error -> {
                            Toast.makeText(
                                this@recyleviewActivity,
                                state.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }

    }
}