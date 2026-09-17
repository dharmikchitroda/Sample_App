    package com.example.sample_app.ui.theme.Services

    import android.app.Notification
    import android.app.NotificationChannel
    import android.app.NotificationManager
    import android.app.PendingIntent
    import android.app.Service
    import android.content.Intent
    import android.media.MediaPlayer
    import android.os.Build
    import android.os.IBinder
    import android.util.Log
    import com.example.sample_app.R
    import com.example.sample_app.ui.theme.activity.MusicActivity

    class MusicService : Service() {

        private var mediaPlayer: MediaPlayer? = null
        private fun createNotificationChannel() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                val channel = NotificationChannel(
                    "Music_notification",
                    "play notiication",
                    NotificationManager.IMPORTANCE_HIGH
                )

                val manager = getSystemService(NotificationManager::class.java)
                manager.createNotificationChannel(channel)
            }
        }

        private fun createNotification(): Notification {

            val penIntent = Intent(this, MusicActivity::class.java)

            val pendingIntent = PendingIntent.getActivity(
                this,
                100,
                penIntent,
                PendingIntent.FLAG_IMMUTABLE
            )

            return Notification.Builder(this, "Music_notification")
                .setContentTitle("Music Player")
                .setContentText("Music is playing")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.outline_music_note)
                .build()

        }

        override fun onCreate() {

            createNotificationChannel()
            val notification = createNotification()

            startForeground(101, notification)

            mediaPlayer = MediaPlayer.create(this, R.raw.music)

            super.onCreate()
        }

        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

            mediaPlayer?.start()
            return START_STICKY

        }

        override fun onBind(intent: Intent): IBinder? {
            return null
        }

        override fun onDestroy() {

            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null

            super.onDestroy()
        }
    }