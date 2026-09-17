package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sample_app.databinding.ActivityCalculatorBinding

class CalculatorActivity : ComponentActivity() {

    lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsum.setOnClickListener {
            val a = binding.editTextText.text.toString().toDoubleOrNull() ?: 0.0
            val b = binding.editTextText2.text.toString().toDoubleOrNull() ?: 0.0
            val result = addition(a, b)
            binding.tvresult.text = "Result: ${formatNumber(result)}"
        }

        binding.btnminus.setOnClickListener {
            val a = binding.editTextText.text.toString().toDoubleOrNull() ?: 0.0
            val b = binding.editTextText2.text.toString().toDoubleOrNull() ?: 0.0
            val result = subtraction(a, b)
            binding.tvresult.text = "Result: ${formatNumber(result)}"
        }

        binding.btnmul.setOnClickListener {
            val a = binding.editTextText.text.toString().toDoubleOrNull() ?: 0.0
            val b = binding.editTextText2.text.toString().toDoubleOrNull() ?: 0.0
            val result = multiplication(a, b)
            binding.tvresult.text = "Result: ${formatNumber(result)}"
        }

        binding.btndiv.setOnClickListener {
            val a = binding.editTextText.text.toString().toDoubleOrNull() ?: 0.0
            val b = binding.editTextText2.text.toString().toDoubleOrNull() ?: 0.0
            if (b == 0.0) {
                binding.tvresult.text = "Cannot divide by 0"
            } else {
                val result = division(a, b)
                binding.tvresult.text = "Result: ${formatNumber(result)}"
            }
        }
    }

    private fun formatNumber(number: Double): String {
        return if (number % 1 == 0.0) {
            number.toLong().toString()
        } else {
            number.toString()
        }
    }

    fun addition(a: Double = 0.0, b: Double = 0.0): Double {
        return a + b
    }

    fun subtraction(a: Double, b: Double): Double {
        return a - b
    }

    fun multiplication(a: Double, b: Double): Double {
        return a * b
    }

    fun division(a: Double, b: Double): Double {
        if (b == 0.0) return 0.0
        return a / b
    }
}