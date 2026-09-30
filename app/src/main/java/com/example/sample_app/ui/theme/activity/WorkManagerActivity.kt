package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.sample_app.R
import com.example.sample_app.ui.theme.Worker.DemoWorker

class WorkManagerActivity : AppCompatActivity() {

private val workManager = WorkManager.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        doWork()
    }

    private fun doWork() {
        val request = OneTimeWorkRequest
            .Builder(DemoWorker::class.java)
            .setConstraints(Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build())
            .build()

        workManager.enqueue(request)
        workManager.getWorkInfoByIdLiveData(request.id).observe(this){
            if (it != null){
                Log.d("sample_worker", it.state.name)
            }
        }
    }
}