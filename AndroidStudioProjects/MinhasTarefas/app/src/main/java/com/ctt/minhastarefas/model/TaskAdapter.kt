package com.ctt.minhastarefas.model

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.TaskActivity

class TaskAdapter(private val taskList: MutableList<Task>, private val listener: OnItemClickListener): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val txttaskTitle: TextView = itemView.findViewById(R.id.txtTaskTitle)
        val txttaskDetails: TextView = itemView.findViewById(R.id.txtTaskDetails)

        init {
            itemView.setOnClickListener {
                val position: Int = absoluteAdapterPosition
                Toast.makeText(itemView.context, "teste", Toast.LENGTH_SHORT).show()
            }
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int  = absoluteAdapterPosition
            listener.onItemClick(position)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    //onCreate do item da recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
    }

    //responsável por vincular os dados passados via adapter com os componentes do xml usando onbindviewholder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txttaskTitle.text = taskList[position].title
        holder.txttaskDetails.text = taskList[position].description
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}