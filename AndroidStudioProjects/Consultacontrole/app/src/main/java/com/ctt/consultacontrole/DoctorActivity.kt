package com.ctt.consultacontrole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class DoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor)


        val rvClinics = findViewById<RecyclerView>(R.id.clinicList)
//        rvClinics.adapter = MessageAdapter()
    }
}