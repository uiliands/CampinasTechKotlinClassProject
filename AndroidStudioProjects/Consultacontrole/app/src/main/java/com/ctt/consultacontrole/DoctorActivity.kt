package com.ctt.consultacontrole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_doctor.*

class DoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor)

        btnAddDoctorClinic.setOnClickListener{
            val destinationView = Intent(this@DoctorActivity, ClinicListActivity::class.java)
            startActivity(destinationView)
        }


    }


}