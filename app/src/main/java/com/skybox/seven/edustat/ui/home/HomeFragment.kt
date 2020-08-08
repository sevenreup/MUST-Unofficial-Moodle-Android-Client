package com.skybox.seven.edustat.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.skybox.seven.edustat.databinding.FragmentHomeBinding
import com.skybox.seven.edustat.epoxy.controllers.HomeController
import com.skybox.seven.edustat.util.GridSpacingItemDecoration
import com.skybox.seven.edustat.util.SpacesItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private val homeController = HomeController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.siteInfo.observe(this, Observer {
            viewModel.getCourseList(it.userId)
        })

        viewModel.courseList.observe(this, Observer {
            homeController.setData(false, it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.recycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recycler.addItemDecoration(GridSpacingItemDecoration(2, 40, true, 0))
        binding.recycler.setController(homeController)
        return binding.root
    }
}