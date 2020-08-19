package com.skybox.seven.edustat.util.download

import com.liulishuo.okdownload.DownloadListener
import com.liulishuo.okdownload.DownloadTask
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo
import com.liulishuo.okdownload.core.cause.EndCause
import com.liulishuo.okdownload.core.cause.ResumeFailedCause
import java.lang.Exception

class MoodleDownloadListener(): DownloadListener {
    override fun connectTrialEnd(
        task: DownloadTask,
        responseCode: Int,
        responseHeaderFields: MutableMap<String, MutableList<String>>
    ) {
        TODO("Not yet implemented")
    }

    override fun fetchEnd(task: DownloadTask, blockIndex: Int, contentLength: Long) {
        TODO("Not yet implemented")
    }

    override fun downloadFromBeginning(
        task: DownloadTask,
        info: BreakpointInfo,
        cause: ResumeFailedCause
    ) {
        TODO("Not yet implemented")
    }

    override fun taskStart(task: DownloadTask) {
        TODO("Not yet implemented")
    }

    override fun taskEnd(task: DownloadTask, cause: EndCause, realCause: Exception?) {
        TODO("Not yet implemented")
    }

    override fun connectTrialStart(
        task: DownloadTask,
        requestHeaderFields: MutableMap<String, MutableList<String>>
    ) {
        TODO("Not yet implemented")
    }

    override fun downloadFromBreakpoint(task: DownloadTask, info: BreakpointInfo) {
        TODO("Not yet implemented")
    }

    override fun fetchStart(task: DownloadTask, blockIndex: Int, contentLength: Long) {
        TODO("Not yet implemented")
    }

    override fun fetchProgress(task: DownloadTask, blockIndex: Int, increaseBytes: Long) {
        TODO("Not yet implemented")
    }

    override fun connectEnd(
        task: DownloadTask,
        blockIndex: Int,
        responseCode: Int,
        responseHeaderFields: MutableMap<String, MutableList<String>>
    ) {
        TODO("Not yet implemented")
    }

    override fun connectStart(
        task: DownloadTask,
        blockIndex: Int,
        requestHeaderFields: MutableMap<String, MutableList<String>>
    ) {
        TODO("Not yet implemented")
    }
}