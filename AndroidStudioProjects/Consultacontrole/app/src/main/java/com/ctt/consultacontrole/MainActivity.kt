package com.ctt.consultacontrole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClinic.setOnClickListener{
            val destinationView = Intent(this@MainActivity, ClinicActivity::class.java)
            startActivity(destinationView)
        }

        btnDoctor.setOnClickListener{
            val destinationView = Intent(this@MainActivity, DoctorActivity::class.java)
            startActivity(destinationView)
        }
    }

}