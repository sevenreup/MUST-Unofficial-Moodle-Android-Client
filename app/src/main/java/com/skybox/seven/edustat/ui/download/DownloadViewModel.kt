package com.skybox.seven.edustat.ui.download

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.skybox.seven.edustat.model.DownloadFile
import com.skybox.seven.edustat.repository.DownloadedFilesRepository

class DownloadViewModel @ViewModelInject constructor(private val downloadsRepository: DownloadedFilesRepository) : ViewModel(){
    val files: LiveData<List<DownloadFile>> = downloadsRepository.getAllDownloadingTask()
}