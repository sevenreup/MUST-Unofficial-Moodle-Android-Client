package com.skybox.seven.edustat.ui.section

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.databinding.FragmentSectionBinding

class SectionFragment : Fragment() {
    private lateinit var binding: FragmentSectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSectionBinding.inflate(inflater, container, false)
        return binding.root
    }

}