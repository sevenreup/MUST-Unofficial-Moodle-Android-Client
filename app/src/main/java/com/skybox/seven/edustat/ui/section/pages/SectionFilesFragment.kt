package com.skybox.seven.edustat.ui.section.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.skybox.seven.edustat.databinding.ViewRecyclerviewBinding
import com.skybox.seven.edustat.epoxy.controllers.SectionFilesController
import com.skybox.seven.edustat.ui.section.SectionViewModel


class SectionFilesFragment : Fragment() {
    private val viewModel: SectionViewModel by activityViewModels()
    private lateinit var binding: ViewRecyclerviewBinding
    private val controller = SectionFilesController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.downloadable.observe(this, Observer {
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