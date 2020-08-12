package com.skybox.seven.edustat.epoxy.controllers

import android.view.View
import com.airbnb.epoxy.Typed2EpoxyController
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.course.SectionContainer
import com.skybox.seven.edustat.epoxy.course.SectionOverViewModel_
import com.skybox.seven.edustat.model.Section

class CourseController (private val callbacks: SessionCallback): Typed2EpoxyController<Boolean, List<Section>>() {
    override fun buildModels(loading: Boolean?, sections: List<Section>?) {
        sections?.forEach {
            val section = SectionContainer()
            section.title = it.name

            val sectionModel = SectionOverViewModel_().id(it.id).section(section)

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
                sectionModel.listener{_,_,view,_ -> callbacks.onSectionClick(it, view)}
                if (module.description != null) section.firstSummary = module.description
            }
            sectionModel.addTo(this)
        }
    }

    interface SessionCallback {
        fun onSectionClick(section: Section, view: View)
    }
}