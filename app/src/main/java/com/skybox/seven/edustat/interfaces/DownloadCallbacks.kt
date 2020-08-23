package com.skybox.seven.edustat.interfaces

import com.liulishuo.okdownload.DownloadTask
import com.liulishuo.okdownload.core.cause.EndCause

interface DownloadCallbacks {
    fun onDownloadTaskStart(task: DownloadTask)
    fun onDownloadTaskEnd(task: DownloadTask, cause: EndCause)
    fun onDownloadTaskProgress(task: DownloadTask, offset: Long)
    fun onDownloadTaskConnected(task: DownloadTask,currentOffset: Long,
                                totalLength: Long)
    fun onDownloadTaskRetry(task: DownloadTask)
}