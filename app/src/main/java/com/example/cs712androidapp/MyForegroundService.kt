package com.example.cs712androidapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import android.util.Log

class MyForegroundService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "Service Created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d("MyService", "Service Started")
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()

        // You can do background work here if needed

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "Service Destroyed")
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
