package com.ctt.minhastarefas

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ctt.minhastarefas.model.Task

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val edtTaskTitle = findViewById<EditText>(R.id.edtTaskTitle)
        val edtTaskDescription = findViewById<EditText>(R.id.edtTaskDescription)
        val btnAddTask = findViewById<Button>(R.id.btnAddTask)

        btnAddTask.setOnClickListener {
            var count = 0
            val taskTitle = edtTaskTitle.text.toString()
            val taskDescription = edtTaskDescription.text.toString()

            val task = Task(++count, taskTitle, taskDescription, "todo")
            tasks.add(task)
            exitTaskActivity(task)
        }

    }

    fun exitTaskActivity(task: Task) {
        var sharedTask: SharedPreferences.Editor
        Toast.makeText(this, getString(R.string.app_saved_task), Toast.LENGTH_SHORT).show()
        val destinationView = Intent(this@TaskActivity, MainActivity::class.java)
        startActivity(destinationView)
    }

    companion object {
        var tasks = mutableListOf<Task>()
    }
}