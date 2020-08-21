package com.skybox.seven.edustat.repository

import com.skybox.seven.edustat.data.DownloadsDAO
import com.skybox.seven.edustat.model.DownloadFile
import javax.inject.Inject

class DownloadedFilesRepository @Inject constructor(val downloadsDAO: DownloadsDAO){
    fun insert(file: DownloadFile) = downloadsDAO.insert(file)
    fun insert(files: List<DownloadFile>) = downloadsDAO.insert(files)

    fun getAllDownloadingTask() = downloadsDAO.getAllUnfinishedTask()

    fun update(file: DownloadFile) = downloadsDAO.updateUsers(file)

    fun update(task: Int) {}
}