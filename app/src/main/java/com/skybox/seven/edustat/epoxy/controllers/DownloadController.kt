package com.skybox.seven.edustat.epoxy.controllers

import com.airbnb.epoxy.TypedEpoxyController
import com.skybox.seven.edustat.epoxy.download.DownloadModel_
import com.skybox.seven.edustat.model.DownloadFile

class DownloadController: TypedEpoxyController<List<DownloadFile>>() {
    override fun buildModels(files: List<DownloadFile>?) {
        files?.forEach {
            DownloadModel_().id(it.moduleId).file(it).addTo(this)
        }
    }
}