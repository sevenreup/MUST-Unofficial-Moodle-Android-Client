package com.skybox.seven.edustat.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.skybox.seven.edustat.databinding.FragmentHomeBinding
import com.skybox.seven.edustat.epoxy.controllers.HomeController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val homeController = HomeController()
        binding.recycler.setController(homeController)

        viewModel.siteInfo.observe(viewLifecycleOwner, Observer {
            viewModel.getCourseList(it.userId)
        })

        viewModel.courseList.observe(viewLifecycleOwner, Observer {
            homeController.setData(false, it)
        })
        return binding.root
    }
}