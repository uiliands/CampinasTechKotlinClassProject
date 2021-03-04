package com.ctt.consultacontrole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.consultacontrole.model.Clinic
import com.ctt.consultacontrole.model.ClinicAdapter

class ClinicListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clinic_view)

        //associa recyclerView a uma variavel
        val rvClinics = findViewById<RecyclerView>(R.id.clinicList)
        
        //Instancie Adapter com lista de dados
        val clinicAdapter = ClinicAdapter(ClinicActivity.clinics)

        //Vincule o adapter da recyclerView a uma instancia da classe adapter
        rvClinics.adapter = clinicAdapter

        //Vincule um gerenciador de layout (LAYOUT MANAGER) a recyclerView
        rvClinics.layoutManager = LinearLayoutManager(this)

    }
}