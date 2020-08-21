package com.skybox.seven.edustat.ui.section.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.databinding.ViewRecyclerviewBinding
import com.skybox.seven.edustat.epoxy.controllers.SectionAllController
import com.skybox.seven.edustat.ui.section.SectionViewModel

class SectionAllFragment : Fragment() {
    private val viewModel: SectionViewModel by activityViewModels()
    private lateinit var binding: ViewRecyclerviewBinding
    private val controller: SectionAllController = SectionAllController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.modules.observe(this, Observer {
            controller.setData(false, it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewRecyclerviewBinding.inflate(inflater, container, false)
        binding.recycler.setController(controller)
        return binding.root
    }
}