package com.skybox.seven.edustat.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.skybox.seven.edustat.databinding.FragmentCourseBinding
import com.skybox.seven.edustat.epoxy.controllers.CourseController
import com.skybox.seven.edustat.model.Section
import com.skybox.seven.edustat.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseFragment : Fragment(), CourseController.SessionCallback{
    private lateinit var binding: FragmentCourseBinding
    private val viewModel: CourseViewModel by viewModels()
    private val activityViewModel: MainViewModel by activityViewModels()
    lateinit var args: CourseFragmentArgs
    lateinit var controller: CourseController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args = CourseFragmentArgs.fromBundle(requireArguments())

        activityViewModel.navigationData.value?.courseName = args.course.shortname
        activityViewModel.navigationData.value?.courseId = args.course.id

        controller = CourseController(this)
        viewModel.courseSections.observe(this, Observer {
            controller.setData(false, it)
        })
        viewModel.getCourseContent(args.course.id)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseBinding.inflate(inflater, container, false)
        binding.activity = this
        binding.lifecycleOwner = this
        binding.recycler.setController(controller)
        return binding.root
    }

    fun navigateBack() {
        findNavController().navigateUp()
    }

    override fun onSectionClick(section: Section, view: View) {
        val action = CourseFragmentDirections.actionCourseFragmentToSectionFragment(section);
        findNavController().navigate(action)
    }
}