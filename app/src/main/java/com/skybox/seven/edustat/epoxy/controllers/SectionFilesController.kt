package com.skybox.seven.edustat.epoxy.controllers

import com.airbnb.epoxy.Typed2EpoxyController
import com.skybox.seven.edustat.epoxy.section.SectionDocumentModel_
import com.skybox.seven.edustat.model.DownloadFile

class SectionFilesController : Typed2EpoxyController<Boolean, List<DownloadFile>>() {
    override fun buildModels(loading: Boolean, downloadList: List<DownloadFile>) {
        downloadList.forEach{
            SectionDocumentModel_().id(it.moduleId).module(it).addTo(this)
        }
    }
}