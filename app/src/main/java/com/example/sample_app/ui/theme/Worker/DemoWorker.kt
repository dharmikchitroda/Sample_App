package com.example.sample_app.ui.theme.Worker

import android.content.Context
import android.util.Log
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class DemoWorker(context: Context, paramters: WorkerParameters) : Worker(context, paramters) {

    override fun doWork(): Result {
        task()
        return Result.success()
    }

    fun task() {
        Thread.sleep(4000)
        Log.d("sample_worker","Task Completed")
    }
}