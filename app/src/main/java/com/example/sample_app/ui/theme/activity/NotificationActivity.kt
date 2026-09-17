        package com.example.sample_app.ui.theme.activity

        import android.Manifest
        import android.app.Activity
        import android.app.NotificationChannel
        import android.app.NotificationManager
        import android.app.PendingIntent
        import android.content.Intent
        import android.content.pm.PackageManager
        import android.os.Build
        import android.os.Bundle
        import android.util.Log
        import android.widget.Button
        import androidx.activity.enableEdgeToEdge
        import androidx.activity.result.ActivityResult
        import androidx.activity.result.contract.ActivityResultContract
        import androidx.activity.result.contract.ActivityResultContracts
        import androidx.appcompat.app.AppCompatActivity
        import androidx.core.app.NotificationCompat
        import androidx.core.content.ContextCompat
        import androidx.core.view.ViewCompat
        import androidx.core.view.WindowInsetsCompat
        import com.example.sample_app.MainActivity
        import com.example.sample_app.R

        class NotificationActivity : AppCompatActivity() {

            // Run-time permission
            private val permissionluncher = registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted ->
                if (isGranted) {
                    // permission mil gayi, notification bhej sakte ho
                } else {
                    // user ne deny kiya
                }
            }


            override fun onCreate(savedInstanceState: Bundle?) {

                super.onCreate(savedInstanceState)

                setContentView(R.layout.activity_notification)
                val button = findViewById<Button>(R.id.btnNotification)

                val intent = Intent(this, MainActivity::class.java)

                val pendingIntent = PendingIntent.getActivity(
                    this,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
                )

                val channel = NotificationChannel(
                    "order_channel_id",   // unique ID
                    "Order Updates",  // name user sees in settings
                    NotificationManager.IMPORTANCE_HIGH
                )

                val notificationManager = getSystemService(NotificationManager::class.java)
                notificationManager.createNotificationChannel(channel)


                val notification = NotificationCompat.Builder(this, "order_channel_id")
                    .setSmallIcon(R.drawable.images)
                    .setContentTitle("simple notification ")
                    .setContentText("btn click and popup show notification")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true )
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .build()

                button.setOnClickListener {

                    Log.d("LogNOTIFICATION", "Button clicked ho gya ")
                    notificationManager.notify(2, notification)

                }

                asknotificationPermission()
            }


            private fun asknotificationPermission() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.POST_NOTIFICATIONS
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        permissionluncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                    }
                }

            }
        }