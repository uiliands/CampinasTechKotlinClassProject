package com.ctt.minhastarefas

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager): FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    //lista de títulos
    private val fragmentTitleList: ArrayList<String> = ArrayList()

    //adiciona fragments e títulos as listas devidas
    fun addFragmentTitle(title: String) {
        fragmentTitleList.add(title)
    }

    //qtd. de fragments a serem utilizadas
    override fun getCount(): Int {
        return 3
    }

    //relação entre item (position) e a fragment a ser exibida
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> TaskToDoFragment()
            1 -> TaskToDoFragment()
            2 -> TaskToDoFragment()
            else -> TaskToDoFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList.get(position)
    }
}