package com.skybox.seven.edustat.epoxy.controllers

import com.airbnb.epoxy.Typed2EpoxyController
import com.skybox.seven.edustat.epoxy.course.CourseModel_
import com.skybox.seven.edustat.model.Course

class HomeController: Typed2EpoxyController<Boolean, List<Course>>() {
    override fun buildModels(loading: Boolean?, courses: List<Course>?) {
        courses?.forEach {
            CourseModel_().id(it.id)
                .course(it)
                .listerner{_,_,_,position ->}
                .addTo(this)
        }
    }
}