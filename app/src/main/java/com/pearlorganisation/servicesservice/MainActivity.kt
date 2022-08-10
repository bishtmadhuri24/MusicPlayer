package com.pearlorganisation.servicesservice

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.app.ServiceCompat.STOP_FOREGROUND_REMOVE
import androidx.core.app.ServiceCompat.stopForeground
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var play:ImageView
    lateinit var stop:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val window=window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(Color.parseColor("#7397A7"))
        play=findViewById(R.id.play)
        stop=findViewById(R.id.stop)

        play!!.setOnClickListener(this)
        stop.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        if (p0==play){
           // startService(Intent(this,NewService::class.java))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(Intent(this,MyForgroundService::class.java))
            }
            stop.isVisible=true
            play.isVisible=false

        }
        else{
            if (p0==stop){
               // stopService(Intent(this,NewService::class.java))
                play.isVisible=true
                stop.isVisible=false

//                stopService(Intent(this,MyForgroundService::class.java))
            }
        }
    }
}