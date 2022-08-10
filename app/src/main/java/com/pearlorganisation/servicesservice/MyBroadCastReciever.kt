package com.pearlorganisation.servicesservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class MyBroadCastReciever:BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p1!!.action.equals(Intent.ACTION_BOOT_COMPLETED))
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                p0!!.startForegroundService(Intent(p0,MyForgroundService::class.java))
            }
        }

    }
}