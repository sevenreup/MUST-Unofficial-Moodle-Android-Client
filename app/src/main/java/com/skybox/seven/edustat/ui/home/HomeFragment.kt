package com.skybox.seven.edustat.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.skybox.seven.edustat.databinding.FragmentHomeBinding
import com.skybox.seven.edustat.epoxy.controllers.HomeController
import com.skybox.seven.edustat.model.Course
import com.skybox.seven.edustat.util.GridSpacingItemDecoration
import com.skybox.seven.edustat.util.SpacesItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeController.CourseCallbacks{
    val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private val homeController = HomeController(this)

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
        binding.lifecycleOwner = this
        binding.fragment = this
        binding.recycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recycler.addItemDecoration(GridSpacingItemDecoration(2, 40, true, 0))
        binding.recycler.setController(homeController)
        return binding.root
    }

    override fun onCourseClick(course: Course, view: View) {
        val action = HomeFragmentDirections.actionStartScreenToCourseFragment(course)
        findNavController().navigate(action)
    }
}