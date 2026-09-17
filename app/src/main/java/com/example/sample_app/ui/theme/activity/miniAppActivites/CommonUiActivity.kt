package com.example.sample_app.ui.theme.activity.miniAppActivites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.sample_app.R
import com.example.sample_app.databinding.ActivityCommonUiBinding
import com.example.sample_app.databinding.ActivityLoginInBinding
import com.example.sample_app.ui.theme.Fragment.HomeFragment
import com.example.sample_app.ui.theme.Fragment.ListFragment
import com.example.sample_app.ui.theme.Fragment.ProfileFragment
import com.example.sample_app.ui.theme.viewmodels.MiniAppViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommonUiActivity : AppCompatActivity() {

    lateinit var binding: ActivityCommonUiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCommonUiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            replacefragment(HomeFragment())
        }

        binding.bottomNavigationView.setOnItemSelectedListener  { items ->
            when (items.itemId) {
                R.id.home -> {

                    replacefragment(HomeFragment())
                    true
                }
                R.id.characters -> {
                    replacefragment(ListFragment())
                    true
                }
                R.id.profile -> {
                    replacefragment(ProfileFragment())
                    true
                }
                else -> false

            }

        }

    }

    private fun replacefragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}