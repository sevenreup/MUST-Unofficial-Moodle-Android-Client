package com.skybox.seven.edustat.epoxy.controllers

import android.util.Log
import com.airbnb.epoxy.Typed2EpoxyController
import com.skybox.seven.edustat.epoxy.section.SectionDocumentModel_
import com.skybox.seven.edustat.model.DownloadFile

private const val TAG = "SectionFilesController"
class SectionFilesController : Typed2EpoxyController<Boolean, HashMap<String, DownloadFile>>() {
    override fun buildModels(loading: Boolean, downloadList: HashMap<String, DownloadFile>) {
        downloadList.forEach{
            Log.e(TAG, "buildModels: ${it.value.downloaded} ${it.value.downloadStatus}")
            SectionDocumentModel_()
                .id(it.value.moduleId)
                .filename(it.value.filename)
                .progress(it.value.progress)
                .downloadStatus(it.value.downloadStatus)
                .description(it.value.description)
                .addTo(this)
        }
    }
}