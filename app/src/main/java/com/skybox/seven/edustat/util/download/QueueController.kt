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
                      downloadTasks: HashMap<String, DownloadFile>, course: String, section: String): HashMap<String, DownloadFile> {

        downloadTasks.forEach{
            val parentFile = File(getParentFile(context), "${course}/$section")
            val task = DownloadTask.Builder(it.value.fileUrl, parentFile)
                .setMinIntervalMillisCallbackProcess(30)
                .setFilename(it.value.filename)
                .setPassIfAlreadyCompleted(false)
                .build()
            TagUtil.saveTaskInfo(task, it.value)
            unifiedListenerManager.addAutoRemoveListenersWhenTaskEnd(task.id)
            unifiedListenerManager.attachAndEnqueueIfNotRun(task, listener)
            it.value.taskId = task.id
            it.value.downloaded = false
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
        unifiedListenerManager.addAutoRemoveListenersWhenTaskEnd(task.id)
        unifiedListenerManager.attachAndEnqueueIfNotRun(task, listener)
        downloadTask.taskId = task.id
        downloadedFilesRepository.insert(downloadTask)
    }
}