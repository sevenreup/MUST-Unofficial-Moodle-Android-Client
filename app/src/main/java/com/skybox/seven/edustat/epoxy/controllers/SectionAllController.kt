package com.skybox.seven.edustat.epoxy.controllers

import com.airbnb.epoxy.Typed2EpoxyController
import com.skybox.seven.edustat.epoxy.section.SectionForumModel_
import com.skybox.seven.edustat.epoxy.section.SectionLessonModel_
import com.skybox.seven.edustat.model.Module

class SectionAllController : Typed2EpoxyController<Boolean, List<Module>>() {
    override fun buildModels(loading: Boolean, modules: List<Module>) {

        if (modules.isNotEmpty()) {
            modules.forEach {
                when (it.modname) {
                    "chat" -> {
                       SectionForumModel_().id(it.id).module(it).addTo(this)
                    }
                    else -> {
                        SectionLessonModel_().id(it.id).module(it).addTo(this)
                    }
                }
            }
        }
    }
}