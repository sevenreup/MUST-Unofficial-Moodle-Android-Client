package com.skybox.seven.edustat.util.download

import android.content.Context
import com.liulishuo.okdownload.*
import com.skybox.seven.edustat.model.DownloadFiles
import com.skybox.seven.edustat.util.getParentFile
import java.io.File


class QueueController {
    fun initTaskQueue(context: Context, listener: DownloadListener, downloadTasks: List<DownloadFiles>, course: String, section: String) {
        val parentFile = File(getParentFile(context), "${course}/$section")
        downloadTasks.forEach{
            val task = DownloadTask.Builder(it.fileUrl, parentFile)
                .setMinIntervalMillisCallbackProcess(30)
                .setPassIfAlreadyCompleted(false)
                .build()
            TagUtil.saveTaskName(task, it.filename)
            task.enqueue(listener)
        }
    }

    fun addFile(context: Context, listener: DownloadListener, downloadTask: DownloadFiles, course: String, section: String) {
        val parentFile = File(getParentFile(context), "${course}/$section")
        val task = DownloadTask.Builder(downloadTask.fileUrl, parentFile)
            .setMinIntervalMillisCallbackProcess(30)
            .setPassIfAlreadyCompleted(false)
            .build()
        TagUtil.saveTaskName(task, downloadTask.filename)
        task.enqueue(listener)
    }
}