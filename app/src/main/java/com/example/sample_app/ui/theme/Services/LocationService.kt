package com.example.sample_app.ui.theme.Services

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat
import com.example.sample_app.R
import com.example.sample_app.ui.theme.activity.ServiceActivity

class LocationService : Service() {

    private lateinit var notificationManager: NotificationManager

    private val notificationChannel = NotificationChannel(
        "location_notification",
        "Location",
        NotificationManager.IMPORTANCE_HIGH
    )


    override fun onCreate() {
        super.onCreate()

        notificationManager = getSystemService(NotificationManager::class.java)

        notificationManager.createNotificationChannel(notificationChannel)
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val serviceIntent = Intent(this, ServiceActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(
            this,
            101,
            serviceIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, "location_notification")
            .setSmallIcon(R.drawable.images)
            .setContentTitle("Tracking Location")
            .setContentIntent(pendingIntent)
            .setContentText("Getting your location in background")
            .build()


//        ServiceCompat.startForeground(1001, notification)
        startForeground(1001, notification)
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}