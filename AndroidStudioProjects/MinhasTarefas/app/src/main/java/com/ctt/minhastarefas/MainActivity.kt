package com.ctt.minhastarefas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.ctt.minhastarefas.model.TaskAdapter
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFloating = findViewById<ExtendedFloatingActionButton>(R.id.btn_floating)
        btnFloating.setOnClickListener() {
            val destinationView = Intent(this, TaskActivity::class.java)
            startActivity(destinationView)
        }


        //get view items
        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager>(R.id.viewPager)

        setupViewPager()

    }

    fun setupViewPager() {
        val adapter = PageAdapter(supportFragmentManager)
        adapter.addFragmentTitle(getString(R.string.task_tab_to_do))
        adapter.addFragmentTitle(getString(R.string.task_tab_in_Process))
        adapter.addFragmentTitle(getString(R.string.task_tab_done))

        //vincula fragments a viewPager
        viewPager.adapter = adapter
        //vincula a viewPager ao tabLyout
        tabLayout.setupWithViewPager(viewPager)
    }

}