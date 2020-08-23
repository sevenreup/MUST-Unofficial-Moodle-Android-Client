package com.skybox.seven.edustat.ui.section

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.skybox.seven.edustat.adapter.SectionAdapter
import com.skybox.seven.edustat.databinding.FragmentSectionBinding
import com.skybox.seven.edustat.model.DownloadStatus
import com.skybox.seven.edustat.ui.main.MainViewModel
import com.skybox.seven.edustat.util.notifyObserver
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "SectionFragment"
@AndroidEntryPoint
class SectionFragment : Fragment() {
    private lateinit var binding: FragmentSectionBinding
    lateinit var args: SectionFragmentArgs
    private val viewModel: SectionViewModel by activityViewModels()
    private val activityViewModel: MainViewModel by activityViewModels()
    lateinit var adapter: SectionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args = SectionFragmentArgs.fromBundle(requireArguments())
        viewModel.modules.value = args.section.modules

        activityViewModel.navigationData.value?.sectionName = args.section.name
        activityViewModel.navigationData.value?.sectionID = args.section.id
        viewModel.workOnModules(args.section.modules, activityViewModel.navigationData.value!!)

        viewModel.getDBDownloads(activityViewModel.navigationData.value?.courseId!!,args.section.id).observe(this, Observer {
            Log.e(TAG, "onCreate: ${it.size}")
            it.forEach {down ->
                val file = viewModel.downloadsMap.value?.get(down.moduleId.toString())
                if (file != null) {
                    if (down.downloaded) {
                        Log.e(TAG, "onCreate: this is available")
                        down.downloadStatus = DownloadStatus.DOWNLOADED
                        down.progress = 100L
                        viewModel.downloadsMap.value?.set(down.moduleId.toString(), down)
                    }
                }
            }
            viewModel.downloadsMap.notifyObserver()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSectionBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.fragment = this
        viewModel.modules.observe(viewLifecycleOwner, Observer {
            adapter = if (it.isEmpty() && viewModel.downloadsMap.value!!.isNotEmpty()) {
                SectionAdapter(this, SectionAdapter.Companion.TYPE.files)
            } else if (it.isNotEmpty() && viewModel.downloadsMap.value!!.isNotEmpty()) {
                SectionAdapter(this, SectionAdapter.Companion.TYPE.ALL)
            } else {
                SectionAdapter(this, SectionAdapter.Companion.TYPE.data)
            }
            binding.viewPager.adapter = adapter
        })
        return binding.root
    }

    fun startDownload() {
        viewModel.downloadAll(requireContext(), activityViewModel.navigationData.value!!)
    }

}