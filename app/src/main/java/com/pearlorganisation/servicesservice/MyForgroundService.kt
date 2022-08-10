package com.pearlorganisation.servicesservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyForgroundService: Service() {

    lateinit var player: MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
                player= MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player.isLooping=true
        player.start()
//
        return super.onStartCommand(intent, flags, startId)
    }
//
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        player= MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
//        player.isLooping=true
//        player.start()
//
////        return START_STICKY
//    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}