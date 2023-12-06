package com.rfid.jobgpt.work

import android.content.Context
import android.util.Log
import androidx.compose.ui.res.stringResource
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.rfid.jobgpt.R

class ChatGptWorker(
    val context: Context,
    val params: WorkerParameters
): Worker(context, params) {

    override fun doWork(): Result {
        Log.d(context.getString(R.string.app_name), "Work started! ChatGPT stuff in progress.")
        return Result.success()
    }
}