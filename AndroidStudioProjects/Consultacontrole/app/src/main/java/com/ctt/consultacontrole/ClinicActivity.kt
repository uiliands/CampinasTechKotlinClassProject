package com.ctt.consultacontrole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ctt.consultacontrole.model.Clinic
import kotlinx.android.synthetic.main.activity_clinic.*

class ClinicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clinic)

        //lista para utilizar na recyclerview
        var clinics = mutableListOf<Clinic>()

        btnAddClinic.setOnClickListener {
            var count = 0
            //gravar todos os valores dos EditText em variáveis
            val clinicName = txtClinicItemName.text.toString()
            val clinicAddress = txtClinicAddress.text.toString()
            val clinicDistrict = txtClinicDistrict.text.toString()
            val clinicCity = txtClinicCity.text.toString()
            val clinicPhone = txtClinicPhone.text.toString()

            //gravar os valores na instância do objeto desejado:
            val clinic = Clinic(++count, clinicName, clinicAddress, clinicDistrict, clinicCity, clinicPhone)
            clinics.add(clinic)
            saveClinic(clinic)
        }
    } //end onCreate

    fun saveClinic(clinic: Clinic) {
        Toast.makeText(this, getString(R.string.app_clinicSaved), Toast.LENGTH_SHORT)
        val destinationView = Intent(this@ClinicActivity, MainActivity::class.java)
        startActivity(destinationView)
    }

}