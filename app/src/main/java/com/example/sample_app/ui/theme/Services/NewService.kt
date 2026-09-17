package com.example.sample_app.ui.theme.Services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NewService : Service() {

    private val binderObject = LocalBinder()
    inner class LocalBinder : Binder() {
        fun getService(): NewService {
            return this@NewService
        }
    }

    override fun onBind(intent: Intent?): IBinder {
        return binderObject

    }


    val serviceScope = CoroutineScope(Dispatchers.IO)

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

      Log.d("Service123", "Service calling code")

        serviceScope.launch {
            performlongtask()
        }


        return START_STICKY
    }

    private suspend fun performlongtask() {

        while (true) {
            delay(1000)
            Log.d("Service123", "Service Running...")

        }
    }

    override fun onDestroy() {

        serviceScope.cancel()

        Log.d("Service123", "Service Destroy")

        super.onDestroy()

    }

    fun showMessage() {
        Log.d("Service123", "Service function called")
    }

}