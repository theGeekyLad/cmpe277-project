package com.rfid.jobgpt.work

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.rfid.jobgpt.R
import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit

class JobsWorker(
    val context: Context,
    val params: WorkerParameters
): Worker(context, params) {

    override fun doWork(): Result {
        Log.d(context.getString(R.string.app_name), "Work started! Job sync stuff in progress: " + ZonedDateTime.now().toString())

        val constraints = Constraints
            .Builder()
            .setRequiresCharging(true)
            .build()

        val jobsWorkRequest = OneTimeWorkRequestBuilder<JobsWorker>()
            .setConstraints(constraints)
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()

        WorkManager
            .getInstance(applicationContext)
            .enqueue(jobsWorkRequest)


        return Result.success()
    }
}