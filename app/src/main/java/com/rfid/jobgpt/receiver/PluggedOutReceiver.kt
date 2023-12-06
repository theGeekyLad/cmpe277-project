package com.rfid.jobgpt.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.rfid.jobgpt.R

class PluggedOutReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(context.getString(R.string.app_name), "Device is plugged out.")
    }
}