package com.ctt.consultacontrole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
        //splash screen loading time
        private val SPLASH_SCREEN_TIME_OUT: Long = 3000 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            //execute once timer is over
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_SCREEN_TIME_OUT)
    }
}