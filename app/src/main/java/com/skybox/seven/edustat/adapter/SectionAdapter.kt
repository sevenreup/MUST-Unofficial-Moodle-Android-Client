package com.skybox.seven.edustat.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.skybox.seven.edustat.ui.section.pages.SectionAllFragment
import com.skybox.seven.edustat.ui.section.pages.SectionFilesFragment

class SectionAdapter(val fragment: Fragment, val type: TYPE) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = when (type) {
        TYPE.ALL -> 2
        else -> 1
    }

    override fun createFragment(position: Int): Fragment {
        return when (type) {
            TYPE.ALL -> {
                if (position == 0) SectionAllFragment()
                else SectionFilesFragment()
            }
            TYPE.data -> SectionAllFragment()
            else -> SectionFilesFragment()
        }
    }

    companion object {
        enum class TYPE {
            ALL,
            files,
            data
        }
    }

}