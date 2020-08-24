package com.skybox.seven.edustat.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.transition.MaterialElevationScale
import com.google.android.material.transition.MaterialFadeThrough
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.databinding.FragmentHomeBinding
import com.skybox.seven.edustat.epoxy.controllers.HomeController
import com.skybox.seven.edustat.model.Course
import com.skybox.seven.edustat.ui.main.MainViewModel
import com.skybox.seven.edustat.util.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeController.CourseCallbacks{
    val viewModel: HomeViewModel by viewModels()
    val activityViewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentHomeBinding
    private val homeController = HomeController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough().apply {
            duration = resources.getInteger(R.integer.edu_motion_duration_large).toLong()
        }
        activityViewModel.siteInfo.observe(this, Observer {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }

    override fun onCourseClick(course: Course, view: View) {
        exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.edu_motion_duration_large).toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.edu_motion_duration_large).toLong()
        }
        val extras = FragmentNavigatorExtras(view to getString(R.string.course_card_detail_transition_name))
        val action = HomeFragmentDirections.actionStartScreenToCourseFragment(course)
        findNavController().navigate(action, extras)
    }
}