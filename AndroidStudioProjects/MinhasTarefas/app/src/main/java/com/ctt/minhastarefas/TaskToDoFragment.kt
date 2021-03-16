package com.ctt.minhastarefas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.minhastarefas.model.TaskAdapter

class TaskToDoFragment : Fragment(), TaskAdapter.OnItemClickListener {


    //OnCreate da Fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_to_do, container, false)
    }

    //fragment ser criada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgEmpty = view.findViewById<ImageView>(R.id.imgEmpty)
        if (TaskActivity.tasks.size > 0) {
            imgEmpty.setVisibility(View.INVISIBLE)
        }
        //associa recyclerView a uma variavel
        val rvTask = view.findViewById<RecyclerView>(R.id.taskList)

        //Instancie Adapter com lista de dados
        val taskAdapter = TaskAdapter(TaskActivity.tasks, listener = this)

        //Vincula a recyclerView a uma instancia da classe adapter
        rvTask.adapter = taskAdapter

        //Vincula um gerenciador de layout (LAYOUT MANAGER) a recyclerView
        rvTask.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onItemClick(position: Int) {
        activity?.let {
            val txtTaskDetailsActivity = view?.findViewById<TextView>(R.id.txtEditTask)

            txtTaskDetailsActivity?.text = "teste"

            val intent = Intent(it, TaskDetailsActivity::class.java)
            it.startActivity(intent)
        }
    }
}