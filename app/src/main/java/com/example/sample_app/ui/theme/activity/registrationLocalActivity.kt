package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.sample_app.databinding.ActivityRegistrationLocalBinding
import com.example.sample_app.ui.theme.LocalData.Room.MyEntity
import com.example.sample_app.ui.theme.LocalData.Sqlitehelper
import com.example.sample_app.ui.theme.viewmodels.RoomVIewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class registrationLocalActivity : ComponentActivity() {

    private lateinit var binding: ActivityRegistrationLocalBinding
    private val viewmodel: RoomVIewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrationLocalBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btnSQLite.setOnClickListener {

            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val mobile = binding.etMobile.text.toString().trim()
            val address = binding.etAddress.text.toString().trim()

            binding.nameLayout.error = null
            binding.emailLayout.error = null
            binding.mobileLayout.error = null
            binding.addressLayout.error = null

            if (!isValidName(name)) {

                binding.nameLayout.error = "Enter name in proper format"

            } else if (!isValidEmail(email)) {

                binding.emailLayout.error = "Enter valid email"

            } else if (!isValidMobile(mobile)) {

                binding.mobileLayout.error = "Enter valid mobile number"

            } else if (!isValidAddress(address)) {

                binding.addressLayout.error = "Enter valid address"

            } else {

                val savdone = Sqlitehelper(this).insert(name, email, mobile, address)

                binding.etName.text?.clear()
                binding.etEmail.text?.clear()
                binding.etMobile.text?.clear()
                binding.etAddress.text?.clear()

                if (savdone) {
                    Toast.makeText(this, "Saved successfully!", Toast.LENGTH_SHORT).show()

                } else Toast.makeText(this, "Failed to save", Toast.LENGTH_SHORT).show()

            }

        }

        binding.btnRoom.setOnClickListener {

            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val mobile = binding.etMobile.text.toString().trim()
            val address = binding.etAddress.text.toString().trim()

            // Clear old errors
            binding.nameLayout.error = null
            binding.emailLayout.error = null
            binding.mobileLayout.error = null
            binding.addressLayout.error = null

            val student_filldata = MyEntity(
                name = name,
                email = email,
                mobile = mobile,
                address = address
            )

            if (!isValidName(name)) {

                binding.nameLayout.error = "Enter name in proper format"

            } else if (!isValidEmail(email)) {

                binding.emailLayout.error = "Enter valid email"

            } else if (!isValidMobile(mobile)) {

                binding.mobileLayout.error = "Enter valid mobile number"

            } else if (!isValidAddress(address)) {

                binding.addressLayout.error = "Enter valid address"

            } else {
                viewmodel.insert(student_filldata)

                binding.etName.text?.clear()
                binding.etEmail.text?.clear()
                binding.etMobile.text?.clear()
                binding.etAddress.text?.clear()

                makeToast("Form submitted successfully")

            }
        }

    }

    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidMobile(mobile: String): Boolean {
        return mobile.isNotEmpty() && Patterns.PHONE.matcher(mobile).matches()
    }

    private fun isValidName(name: String): Boolean {
        return name.isNotEmpty() && name.length >= 3
    }

    private fun isValidAddress(address: String): Boolean {
        return address.isNotEmpty() && address.length >= 10
    }

    fun makeToast(message: String) {
        Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()

        val a = Patterns.EMAIL_ADDRESS.matcher("").matches()

    }
}



