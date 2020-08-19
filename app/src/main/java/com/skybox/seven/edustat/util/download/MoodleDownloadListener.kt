package com.skybox.seven.edustat.util.download

import android.util.Log
import com.liulishuo.okdownload.DownloadListener
import com.liulishuo.okdownload.DownloadTask
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo
import com.liulishuo.okdownload.core.cause.EndCause
import com.liulishuo.okdownload.core.cause.ResumeFailedCause
import java.lang.Exception

private const val TAG = "MoodleDownloadListener"
class MoodleDownloadListener(): DownloadListener {
    override fun connectTrialEnd(
        task: DownloadTask,
        responseCode: Int,
        responseHeaderFields: MutableMap<String, MutableList<String>>
    ) {
        Log.e(TAG, "connectTrialEnd: ${task.tag} code: $responseCode")
    }

    override fun fetchEnd(task: DownloadTask, blockIndex: Int, contentLength: Long) {
        Log.e(TAG, "fetchEnd: ${task.tag} block: $blockIndex length $contentLength")
    }

    override fun downloadFromBeginning(
        task: DownloadTask,
        info: BreakpointInfo,
        cause: ResumeFailedCause
    ) {
        Log.e(TAG, "downloadFromBeginning: ${task.tag} info: ${info.filename} length ${cause.name}")
    }

    override fun taskStart(task: DownloadTask) {
        Log.e(TAG, "taskStart: ${task.tag}")
    }

    override fun taskEnd(task: DownloadTask, cause: EndCause, realCause: Exception?) {
        Log.e(TAG, "taskEnd: ${task.tag} cause: ${cause.name}", realCause)
    }

    override fun connectTrialStart(
        task: DownloadTask,
        requestHeaderFields: MutableMap<String, MutableList<String>>
    ) {
        Log.e(TAG, "connectTrialStart: ${task.tag}")
    }

    override fun downloadFromBreakpoint(task: DownloadTask, info: BreakpointInfo) {
        Log.e(TAG, "downloadFromBreakpoint: ${task.tag}")

    }

    override fun fetchStart(task: DownloadTask, blockIndex: Int, contentLength: Long) {
        Log.e(TAG, "fetchStart: ${task.tag}")
    }

    override fun fetchProgress(task: DownloadTask, blockIndex: Int, increaseBytes: Long) {
        Log.e(TAG, "fetchProgress: ${task.tag}")
    }

    override fun connectEnd(
        task: DownloadTask,
        blockIndex: Int,
        responseCode: Int,
        responseHeaderFields: MutableMap<String, MutableList<String>>
    ) {
        Log.e(TAG, "connectEnd: ${task.tag}")
    }

    override fun connectStart(
        task: DownloadTask,
        blockIndex: Int,
        requestHeaderFields: MutableMap<String, MutableList<String>>
    ) {
        Log.e(TAG, "connectStart: ${task.tag}")
    }
}