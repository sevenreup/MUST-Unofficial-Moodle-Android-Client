package com.skybox.seven.edustat.epoxy.course

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.google.android.material.card.MaterialCardView
import com.google.android.material.chip.Chip
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder
import com.skybox.seven.edustat.model.Course

@EpoxyModelClass(layout = R.layout.model_course)
abstract class CourseModel: EpoxyModelWithHolder<CourseModel.CourseHolder>() {

    @EpoxyAttribute lateinit var course: Course
    @EpoxyAttribute lateinit var listerner: View.OnClickListener

    class CourseHolder: BaseEpoxyHolder() {
        val title by bind<TextView>(R.id.course_title)
        val view by bind<View>(R.id.background)
        val progressBar by bind<ProgressBar>(R.id.progress)
        val shortTitle by bind<Chip>(R.id.short_title)
    }

    override fun bind(holder: CourseHolder) {
        super.bind(holder)
        holder.title.text = course.displayname
        holder.progressBar.progress = course.progress
        holder.shortTitle.text = course.shortname
        val colors = intArrayOf(Color.parseColor("#008000"), Color.parseColor("#ADFF2F"))
        val gradientDrawable = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors)
        gradientDrawable.cornerRadius = 20F
        holder.view.background = gradientDrawable
        holder.setViewClickListener(listerner)
    }

    override fun getDefaultLayout(): Int = R.layout.model_course

    override fun createNewHolder(): CourseHolder = CourseHolder()
}