package com.skybox.seven.edustat.util.download

import android.content.Context
import android.util.Log
import com.liulishuo.okdownload.*
import com.liulishuo.okdownload.core.breakpoint.DownloadStore
import com.skybox.seven.edustat.model.DownloadFile
import com.skybox.seven.edustat.repository.DownloadedFilesRepository
import com.skybox.seven.edustat.util.getParentFile
import java.io.File


object QueueController {
    fun initTaskQueue(context: Context, listener: DownloadListener, unifiedListenerManager: UnifiedListenerManager,
                      downloadTasks: List<DownloadFile>, course: String, section: String): List<DownloadFile> {

        downloadTasks.forEach{
            val parentFile = File(getParentFile(context), "${course}/$section")
            val task = DownloadTask.Builder(it.fileUrl, parentFile)
                .setMinIntervalMillisCallbackProcess(30)
                .setFilename(it.filename)
                .setPassIfAlreadyCompleted(false)
                .build()
            Log.e("TAG", "initTaskQueue: ${it.fileUrl}")
            TagUtil.saveTaskName(task, it.filename)
            unifiedListenerManager.addAutoRemoveListenersWhenTaskEnd(task.id)
            unifiedListenerManager.attachAndEnqueueIfNotRun(task, listener)
            it.taskId = task.id
            it.downloaded = false
        }
        return downloadTasks
    }

    fun addFile(context: Context, listener: DownloadListener, unifiedListenerManager: UnifiedListenerManager,
                downloadTask: DownloadFile, course: String, section: String,
                downloadedFilesRepository: DownloadedFilesRepository
    ) {
        val parentFile = File(getParentFile(context), "${course}/$section")
        val task = DownloadTask.Builder(downloadTask.fileUrl, parentFile)
            .setMinIntervalMillisCallbackProcess(30)
            .setPassIfAlreadyCompleted(false)
            .build()
        TagUtil.saveTaskName(task, downloadTask.filename)
        unifiedListenerManager.addAutoRemoveListenersWhenTaskEnd(task.id)
        unifiedListenerManager.attachAndEnqueueIfNotRun(task, listener)
        downloadTask.taskId = task.id
        downloadedFilesRepository.insert(downloadTask)
    }
}