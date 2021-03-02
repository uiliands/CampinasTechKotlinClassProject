package com.ctt.consultacontrole

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.consultacontrole.model.Clinic
import androidx.recyclerview.widget.RecyclerView.*

//classe para vincular a lista de dados ao item de lista (xml class_item)
class MessageAdapter(private val clinicList: MutableList<Clinic>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    //item final a ser visualizado e inserido
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val clinicName: TextView = view.findViewById(R.id.txtClinicItemName)
    }

    //onCreate do item da recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.clinic_item, parent, false)
        return ViewHolder(view)
    }

    //responsável por vincular os dados com os componentes do xml
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.clinicName.text = clinicList[position].name
    }

    override fun getItemCount(): Int {
        return clinicList.size
    }
}
