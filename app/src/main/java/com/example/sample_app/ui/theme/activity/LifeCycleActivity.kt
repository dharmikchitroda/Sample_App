package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sample_app.databinding.ActivityLifeCycleBinding

class LifeCycleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLifeCycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("act_lifecycle", " call the onCreate Method ")

        binding = ActivityLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
// oop used here :override parent method call and modify that signature according my needs
    override fun onStart() {
        super.onStart()
        Log.d("act_lifecycle", " call the onStart Method ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("act_lifecycle", " call the onResume Method ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("act_lifecycle", " call the onPause Method ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("act_lifecycle", " call the onStop Method ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("act_lifecycle", " call the onRestart Method ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("act_lifecycle", " call the onDestroy Method ")
    }
}