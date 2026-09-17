package com.example.sample_app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReciver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {

            var isairplanon = intent.getBooleanExtra("state", false)

            if (isairplanon) {
                Toast.makeText(context, "Airplane Mode ON", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Airplane Mode OFF", Toast.LENGTH_SHORT).show()
            }
        } else if (intent?.action == "com.example.MY_CUSTOM_BROADCAST") {
            Toast.makeText(context, "Custome BroadCast Recived ", Toast.LENGTH_SHORT).show()
        }
    }
}