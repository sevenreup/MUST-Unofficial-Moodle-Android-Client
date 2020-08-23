package com.skybox.seven.edustat.repository

import com.skybox.seven.edustat.data.DownloadsDAO
import com.skybox.seven.edustat.model.DownloadFile
import javax.inject.Inject

class DownloadedFilesRepository @Inject constructor(private val downloadsDAO: DownloadsDAO){
    fun insert(file: DownloadFile) = downloadsDAO.insert(file)
    fun insert(files: Collection<DownloadFile>) = downloadsDAO.insert(files)

    fun getTask(moduleId: Int) = downloadsDAO.getTask(moduleId)

    fun getAllDownloadingTask() = downloadsDAO.getAllUnfinishedTask(false)

    fun update(file: DownloadFile) = downloadsDAO.updateUsers(file)

    fun updateDownloadStatus(moduleId: Int, path: String) = downloadsDAO.downloadComplete(moduleId, path, true)

    fun getSectionDownload(sectionID: Int, courseID: Int) = downloadsDAO.getAllFinishedSectionFiles(sectionID)
}