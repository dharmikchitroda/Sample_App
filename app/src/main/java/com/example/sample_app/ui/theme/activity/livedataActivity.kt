package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sample_app.databinding.ActivityLivadataBinding
import com.example.sample_app.ui.theme.viewmodels.CounterViewModel

class livedataActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityLivadataBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val viewmodel = CounterViewModel()

        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this

        binding.incBtn.setOnClickListener {
            viewmodel.inc()
        }

        binding.decBtn.setOnClickListener {
            viewmodel.dec()
        }

        viewmodel.count.observe(this) {

            binding.baseText.text =
                if ((viewmodel.count.value ?: 0) < 0) {
                    "count is negative"
                } else if ((viewmodel.count.value ?: 0) % 2 == 0) {
                    "this is even number"
                } else {
                    "this is odd number"
                    }
        }

    }
}