package com.example.sample_app.ui.theme.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sample_app.R
import com.example.sample_app.databinding.ActivityKotlineBasicBinding

class KotlineBasicActivity : ComponentActivity() {

    lateinit var binding: ActivityKotlineBasicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKotlineBasicBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {

            val name: String = binding.etName.text.toString() ?: ""
            val percentage: Double =
                binding.etPercentage.text.toString().toDoubleOrNull() ?: 0.0


            val grade = when {
                percentage > 100 -> "Invalid percentage"

                percentage >= 80 -> "Your grade: A"

                percentage >= 70 -> "Your grade: B"

                percentage >= 50 -> "Your grade: C"

                percentage >= 40 -> "Your grade: D"

                else -> "You failed"
            }

            binding.result.text = "$name → $grade"
        }

        binding.btntable.setOnClickListener {

            val count = binding.ettables.text.toString().toIntOrNull() ?:0

            var table = ""

            for (i in 1..10) {

                table += " $count * $i = ${count * i} \n"

            }

            /* while

           var i : Int = 1
           while ( i > 10 ){}

            */

            /* do-while

               var i : Int = 1
           do{}  while ( i > 10 )
          one time minuimum run

            */
            binding.table.text = table
        }

        binding.btnmovecalcu.setOnClickListener {
            val intent = Intent(this , CalculatorActivity::class.java)
            startActivity(intent)
        }
        binding.btnCollection.setOnClickListener {
            val intent = Intent(this , CollectionActivity::class.java)
            startActivity(intent)
        }
    }
}