package com.ctt.consultacontrole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ClinicActivity.clinics.isNotEmpty()) {
            txtTitle2.setText(ClinicActivity.clinics[0].name)
        }

        imgHospital.setOnClickListener{
            val destinationView = Intent(this@MainActivity, ClinicActivity::class.java)
            startActivity(destinationView)
        }

        imgDoctor.setOnClickListener{
            val destinationView = Intent(this@MainActivity, DoctorActivity::class.java)
            startActivity(destinationView)
        }
    }

}