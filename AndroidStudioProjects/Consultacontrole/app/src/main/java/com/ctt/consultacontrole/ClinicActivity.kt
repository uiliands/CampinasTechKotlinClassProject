package com.ctt.consultacontrole

import android.content.Intent
import android.content.SharedPreferences
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ctt.consultacontrole.model.Clinic
import kotlinx.android.synthetic.main.activity_clinic.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class ClinicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clinic)

        btnSearchZipCode.setOnClickListener {
            searchZipCode(txtClinicZipCode.text.toString())
        }

        btnAddClinic.setOnClickListener {
            var count = 0
            //gravar todos os valores dos EditText em variáveis
            val clinicName = txtClinicItemName.text.toString()
            val clinicStreet = txtClinicStreet.text.toString()
            val clinicDistrict = txtClinicDistrict.text.toString()
            val clinicCity = txtClinicCity.text.toString()
            val clinicPhone = txtClinicPhone.text.toString()

            //gravar os valores na instância do objeto desejado:
            val clinic = Clinic(++count, clinicName, clinicStreet, clinicDistrict, clinicCity, clinicPhone)
            clinics.add(clinic)
            saveClinic(clinic)
        }
    } //end onCreate

    fun searchZipCode(zipCode: String) {
        var url = "https://viacep.com.br/ws/" + zipCode + "/json"
        MyAsyncTask().execute(url)
    }

    inner class MyAsyncTask: AsyncTask<String, String, String>() {
        override fun onPreExecute() {
        }
        override fun doInBackground(vararg params: String?): String {
            try {
                val url = URL(params[0])
                val urlConnection = url.openConnection() as HttpURLConnection
                urlConnection.connectTimeout = 7000
                var instring = ConvertStreamString(urlConnection.inputStream)
                publishProgress(instring)
            } catch (ex: Exception) {
                Log.d("Erro: ", ex.toString())
            }
            return ""
        }
        override fun onProgressUpdate(vararg params: String?) {
            try {
                var json = JSONObject(params[0])
                val cep = json.getString("cep")
                val street = json.getString("logradouro")
                val district = json.getString("bairro")
                val city = json.getString("localidade")
                val estado = json.getString("uf")

                txtClinicStreet.setText(street)
                txtClinicDistrict.setText(district)
                txtClinicCity.setText(city)

            } catch (ex: Exception) {
                Log.d("Erro: ", ex.toString())
            }
        }
        fun ConvertStreamString(inputStream: InputStream): String {
            val reader = BufferedReader(inputStream.reader())
            val content = StringBuilder()
            var line = reader.readLine()
            reader.use { reader ->
                while (line != null) {
                    content.append(line)
                    line = reader.readLine()
                }
            }
            return content.toString()
        }
    }

    fun saveClinic(clinic: Clinic) {
        val sharedClinic: SharedPreferences.Editor
        Toast.makeText(this, getString(R.string.app_clinicSaved), Toast.LENGTH_SHORT)
        val destinationView = Intent(this@ClinicActivity, MainActivity::class.java)
        startActivity(destinationView)
    }

    companion object {
        //lista para utilizar na recyclerview
        var clinics = mutableListOf<Clinic>()
    }

}