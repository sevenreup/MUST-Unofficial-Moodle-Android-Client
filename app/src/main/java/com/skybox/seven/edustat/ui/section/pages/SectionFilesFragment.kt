package com.skybox.seven.edustat.ui.section.pages

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.skybox.seven.edustat.databinding.ViewRecyclerviewBinding
import com.skybox.seven.edustat.epoxy.controllers.SectionFileCallbacks
import com.skybox.seven.edustat.epoxy.controllers.SectionFilesController
import com.skybox.seven.edustat.model.DownloadFile
import com.skybox.seven.edustat.model.DownloadStatus
import com.skybox.seven.edustat.ui.section.SectionViewModel
import com.skybox.seven.edustat.util.selfFileOpenIntent
import java.io.File

private const val TAG = "SectionFilesFragment"

class SectionFilesFragment : Fragment(), SectionFileCallbacks {
    private val viewModel: SectionViewModel by activityViewModels()
    private lateinit var binding: ViewRecyclerviewBinding
    private val controller = SectionFilesController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.downloadsMap.observe(this, Observer {
            Log.e(TAG, "keep om hitting")
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

    override fun onFileClick(file: DownloadFile) {
        when (file.downloadStatus) {
            DownloadStatus.DOWNLOADED, DownloadStatus.COMPLETE -> {
                startActivity(
                    selfFileOpenIntent(
                        requireContext(),
                        file.filePath,
                        file.mimeType,
                        requireActivity().packageName
                    )
                )
            }
            DownloadStatus.FAILED -> {
                val fileNew = File(file.filePath)
                if (fileNew.exists()) {
                    file.downloaded = true
                    viewModel.changeDownloadStatus(file)
                    startActivity(
                        selfFileOpenIntent(
                            requireContext(),
                            file.filePath,
                            file.mimeType,
                            requireActivity().packageName
                        )
                    )
                } else {
                    viewModel.singleDownload(file, requireContext())
                }
            }
            DownloadStatus.IDLE -> {
                viewModel.singleDownload(file, requireContext())
            }
            else -> {
                Toast.makeText(requireContext(), "Wait While Downloading", Toast.LENGTH_LONG).show()
            }
        }

    }
}