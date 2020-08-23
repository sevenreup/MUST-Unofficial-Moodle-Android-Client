package com.skybox.seven.edustat.util.download

import android.util.Log
import com.liulishuo.okdownload.DownloadTask
import com.liulishuo.okdownload.core.cause.EndCause
import com.liulishuo.okdownload.core.cause.ResumeFailedCause
import com.liulishuo.okdownload.core.listener.DownloadListener1
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist
import com.skybox.seven.edustat.interfaces.DownloadCallbacks
import java.lang.Exception

private const val TAG = "MoodleDownloadListener"

class MoodleDownloadListener constructor(private val downloadCallbacks: DownloadCallbacks) :
    DownloadListener1() {
    override fun taskStart(task: DownloadTask, model: Listener1Assist.Listener1Model) {
        val status = "taskStart"
        TagUtil.saveStatus(task, status)
        downloadCallbacks.onDownloadTaskStart(task)
    }

    override fun taskEnd(
        task: DownloadTask,
        cause: EndCause,
        realCause: Exception?,
        model: Listener1Assist.Listener1Model
    ) {
        val status = cause.toString()
        TagUtil.saveStatus(task, status)

        Log.e(TAG, "${task.url} ended with: $cause")
        downloadCallbacks.onDownloadTaskEnd(task, cause)
    }

    override fun progress(task: DownloadTask, currentOffset: Long, totalLength: Long) {
        val status = "progress"
        TagUtil.saveStatus(task, status)
        TagUtil.saveOffset(task, currentOffset)
        Log.i(TAG, "progress " + task.id + " with " + currentOffset)
        downloadCallbacks.onDownloadTaskProgress(task, currentOffset)
    }

    override fun connected(
        task: DownloadTask,
        blockCount: Int,
        currentOffset: Long,
        totalLength: Long
    ) {
        val status = "connected"
        TagUtil.saveStatus(task, status)
        TagUtil.saveOffset(task, currentOffset)
        TagUtil.saveTotal(task, totalLength)

        downloadCallbacks.onDownloadTaskConnected(task, currentOffset, totalLength)
    }

    override fun retry(task: DownloadTask, cause: ResumeFailedCause) {
        val status = "retry"
        TagUtil.saveStatus(task, status)

        downloadCallbacks.onDownloadTaskRetry(task)
    }
}