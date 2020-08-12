package com.skybox.seven.edustat.epoxy.controllers

import com.airbnb.epoxy.Typed2EpoxyController
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.course.SectionContainer
import com.skybox.seven.edustat.epoxy.course.SectionOverViewModel_
import com.skybox.seven.edustat.model.Section

class CourseController: Typed2EpoxyController<Boolean, List<Section>>() {
    override fun buildModels(loading: Boolean?, sections: List<Section>?) {
        sections?.forEach {
            val section = SectionContainer()
            section.title = it.name
            if (it.modules.size > 0) {
                section.sectionEmpty = false
                val module = it.modules[0]
                section.firstTitle = module.name

                it.modules.forEach { mod ->
                    when (mod.modname) {
                        "chat" -> {
                            section.forum++
                            section.firstType = R.drawable.ic_chat
                        }
                        "resource" -> {
                            section.pdf++
                            section.firstType = R.drawable.ic_pdf
                        }
                        else -> {
                            section.doc++
                            section.firstType = R.drawable.ic_pages
                        }
                    }
                }
                if (module.description != null) section.firstSummary = module.description
            }
            SectionOverViewModel_().id(it.id).section(section).addTo(this)
        }
    }
}