package com.skybox.seven.edustat.epoxy.course

import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder

@EpoxyModelClass(layout = R.layout.model_section_overview)
abstract class SectionOverViewModel :
    EpoxyModelWithHolder<SectionOverViewModel.SectionOverViewHolder>() {

    @EpoxyAttribute
    lateinit var section: SectionContainer

    class SectionOverViewHolder : BaseEpoxyHolder() {
        val title by bind<TextView>(R.id.section_title)
        val firstTitle by bind<TextView>(R.id.module_title)
        val firstSummary by bind<TextView>(R.id.module_summary)
        val doc by bind<TextView>(R.id.doc_count)
        val forum by bind<TextView>(R.id.forum_count)
        val pdf by bind<TextView>(R.id.pdf_count)
        val firstType by bind<ImageView>(R.id.module_icon)
        val firstModule by bind<View>(R.id.first_module)
        val countModule by bind<View>(R.id.module_count)
    }

    override fun getDefaultLayout(): Int = R.layout.model_section_overview

    override fun createNewHolder(): SectionOverViewHolder = SectionOverViewHolder()

    override fun bind(holder: SectionOverViewHolder) {
        super.bind(holder)
        holder.title.text = section.title
        if (!section.sectionEmpty) {
            holder.firstTitle.text = section.firstTitle
            if (section.firstSummary != null) holder.firstSummary.text = Html.fromHtml(section.firstSummary)
            else holder.firstSummary.text = ""
            holder.doc.text = section.doc.toString()
            holder.forum.text = section.forum.toString()
            holder.pdf.text = section.pdf.toString()
            holder.firstType.setImageResource(section.firstType)
        } else {
            holder.firstModule.visibility = View.GONE
            holder.countModule.visibility = View.GONE
        }
    }
}

class SectionContainer {
    lateinit var title: String
    lateinit var firstTitle: String
    var firstSummary: String? = null
    @DrawableRes var firstType: Int = R.drawable.ic_pdf
    var sectionEmpty = true
    var completion: Boolean = false
    var doc: Int = 0
    var pdf: Int = 0
    var forum: Int = 0
}