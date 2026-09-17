package com.example.sample_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sample_app.databinding.ActivityMainBinding
import com.example.sample_app.ui.theme.activity.ApiOptbtnActivity
import com.example.sample_app.ui.theme.activity.BroadCastActivity
import com.example.sample_app.ui.theme.activity.CoroutinActivity
import com.example.sample_app.ui.theme.activity.KotlineBasicActivity
import com.example.sample_app.ui.theme.activity.LifeCycleActivity
import com.example.sample_app.ui.theme.activity.LocationActivity
import com.example.sample_app.ui.theme.activity.MusicActivity
import com.example.sample_app.ui.theme.activity.NotificationActivity
import com.example.sample_app.ui.theme.activity.ServiceActivity
import com.example.sample_app.ui.theme.activity.livedataActivity
import com.example.sample_app.ui.theme.activity.miniAppActivites.SingUpActivity
import com.example.sample_app.ui.theme.activity.recyleviewActivity
import com.example.sample_app.ui.theme.activity.registrationLocalActivity
import com.example.sample_app.ui.theme.activity.signupActivity
import com.example.sample_app.ui.theme.activity.regitartionScreenActivity
import com.example.sample_app.ui.theme.activity.task2

// oop used here - made a class
// oop used here -  inherit all activity extend must be ComponentActivity()/AppCompatActivity()

class MainActivity : ComponentActivity() {


    // oop used here : inheritance all inbult binding class is a interface beacuase didnt add constructor here
    lateinit var binding: ActivityMainBinding

    // oop used here :override parent method call and modify that signature accordng my needs
    override fun onCreate(savedInstanceState: Bundle?) {

// oop used here : super parent method call inside ovveride
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



        binding.button1.setOnClickListener {
            val intent = Intent(this, regitartionScreenActivity::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this, task2::class.java)
            startActivity(intent)
        }

        binding.signup.setOnClickListener {
            val intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            val intent = Intent(this, livedataActivity::class.java)
            startActivity(intent)
        }

        binding.recButton.setOnClickListener {
            val intent = Intent(this, recyleviewActivity::class.java)
            startActivity(intent)
        }

        binding.localdataButton.setOnClickListener {
            val intent = Intent(this, registrationLocalActivity::class.java)
            startActivity(intent)
        }

        binding.ApiButton.setOnClickListener {
            val intent = Intent(this, ApiOptbtnActivity::class.java)
            startActivity(intent)
        }

        binding.btnlifecycle.setOnClickListener {
            val intent = Intent(this, LifeCycleActivity::class.java)
            startActivity(intent)
        }

        binding.btnKotlinBasic.setOnClickListener {
            val intent = Intent(this, KotlineBasicActivity::class.java)
            startActivity(intent)
        }

        binding.btnCoroutin.setOnClickListener {
            val intent = Intent(this, CoroutinActivity::class.java)
            startActivity(intent)
        }

        binding.btnminiapp.setOnClickListener {
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }

        binding.btnService.setOnClickListener {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }
        binding.btnmainNotification.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
        binding.btnLocation.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }
        binding.btnMusic.setOnClickListener {
            val intent = Intent(this, MusicActivity::class.java)
            startActivity(intent)
        }
        binding.BroadcastReciever.setOnClickListener {
            val intent = Intent(this, BroadCastActivity::class.java)
            startActivity(intent)
        }

    }


}