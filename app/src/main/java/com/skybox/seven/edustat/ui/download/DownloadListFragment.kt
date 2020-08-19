package com.skybox.seven.edustat.ui.download

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.skybox.seven.edustat.databinding.FragmentDownloadListBinding
import com.skybox.seven.edustat.epoxy.controllers.DownloadController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DownloadListFragment : Fragment() {
    private lateinit var binding: FragmentDownloadListBinding
    private val viewModel: DownloadViewModel by viewModels()
    private val controller = DownloadController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.files.observe(this, Observer {
            controller.setData(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDownloadListBinding.inflate(inflater, container, false)
        binding.recycler.setController(controller)
        return binding.root
    }
}