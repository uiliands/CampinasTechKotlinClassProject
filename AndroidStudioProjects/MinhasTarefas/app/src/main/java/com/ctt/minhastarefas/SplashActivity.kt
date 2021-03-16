package com.ctt.minhastarefas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.HandlerCompat.postDelayed

class SplashActivity : AppCompatActivity() {

    //splash screen loading time
    private val SPLASH_SCREEN_TIME_OUT: Long = 3000 //1sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Handler: allows you to send and process Message and Runnable objects associated with a thread's MessageQueue.
        //Looper: Class used to run a message loop for a thread
        //Causes the Runnable r to be added to the message queue, to be run after the specified amount of time elapses.
        // The runnable will be run on the thread to which this handler is attached.
        Handler(Looper.getMainLooper()).postDelayed({
            //execute once time is over
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_SCREEN_TIME_OUT)
    }

}