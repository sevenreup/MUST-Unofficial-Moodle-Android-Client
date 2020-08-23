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
    fun initTaskQueue(
        context: Context,
        listener: DownloadListener,
        unifiedListenerManager: UnifiedListenerManager,
        downloadTasks: HashMap<String, DownloadFile>,
        course: String,
        section: String
    ): HashMap<String, DownloadFile> {
        val newHash: HashMap<String, DownloadFile> = HashMap()
        downloadTasks.forEach {
            if (!it.value.downloaded) {
                newHash[it.value.moduleId.toString()] =
                    singleFile(it.value, context, listener, unifiedListenerManager, course, section)
            }
        }
        return newHash
    }

    fun singleFile(
        value: DownloadFile,
        context: Context,
        listener: DownloadListener,
        unifiedListenerManager: UnifiedListenerManager,
        course: String,
        section: String
    ): DownloadFile {
        val parentFile = File(getParentFile(context), "${course}/$section")
        val task = DownloadTask.Builder(value.fileUrl, parentFile)
            .setMinIntervalMillisCallbackProcess(30)
            .setFilename(value.filename)
            .setPassIfAlreadyCompleted(false)
            .build()
        TagUtil.saveTaskInfo(task, value)
        unifiedListenerManager.addAutoRemoveListenersWhenTaskEnd(task.id)
        unifiedListenerManager.attachAndEnqueueIfNotRun(task, listener)
        value.taskId = task.id
        value.downloaded = false
        value.dirty = true
        value.filePath = task.file?.toURI().toString()

        return value
    }
}