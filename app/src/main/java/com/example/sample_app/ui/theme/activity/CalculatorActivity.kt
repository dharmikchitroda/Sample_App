package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sample_app.R
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

            val Result = addition(a, b)

            binding.tvresult.text = Result.toString()
        }
        binding.btnminus.setOnClickListener {
            val a = binding.editTextText.text.toString().toDoubleOrNull() ?: 0.0
            val b = binding.editTextText2.text.toString().toDoubleOrNull() ?: 0.0

            val Result = subtraction(a, b)

            binding.tvresult.text = Result.toString()
        }
        binding.btnmul.setOnClickListener {
            val a = binding.editTextText.text.toString().toDoubleOrNull() ?: 0.0
            val b = binding.editTextText2.text.toString().toDoubleOrNull() ?: 0.0

            val Result = multiplication(a, b)

            binding.tvresult.text = Result.toString()
        }
        binding.btndiv.setOnClickListener {
            val a = binding.editTextText.text.toString().toDoubleOrNull() ?: 0.0
            val b = binding.editTextText2.text.toString().toDoubleOrNull() ?: 0.0

            val Result = division(a, b)

            binding.tvresult.text = Result.toString()
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
        return a / b
    }
}