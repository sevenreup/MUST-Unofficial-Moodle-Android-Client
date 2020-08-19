package com.skybox.seven.edustat.ui.section

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.databinding.FragmentSectionBinding
import com.skybox.seven.edustat.epoxy.controllers.SectionController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SectionFragment : Fragment() {
    private lateinit var binding: FragmentSectionBinding
    lateinit var args: SectionFragmentArgs
    private val viewModel: SectionViewModel by viewModels()
    private var controller: SectionController = SectionController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args = SectionFragmentArgs.fromBundle(requireArguments())
        viewModel.modules.value = args.section.modules
        controller.setData(false, args.section.modules)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSectionBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.fragment = this
        binding.recycler.setController(controller)
        return binding.root
    }

    fun startDownload() {
        viewModel.downloadAll(requireContext())
    }

}