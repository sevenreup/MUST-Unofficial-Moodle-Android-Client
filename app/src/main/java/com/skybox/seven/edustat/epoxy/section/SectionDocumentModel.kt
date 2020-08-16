package com.skybox.seven.edustat.epoxy.section

import android.text.Html
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder
import com.skybox.seven.edustat.model.Module

@EpoxyModelClass(layout = R.layout.model_section_document)
abstract class SectionDocumentModel :
    EpoxyModelWithHolder<SectionDocumentModel.SectionDocumentHolder>() {
    @EpoxyAttribute
    lateinit var module: Module

    override fun getDefaultLayout(): Int = R.layout.model_section_document

    override fun createNewHolder(): SectionDocumentHolder = SectionDocumentHolder()

    override fun bind(holder: SectionDocumentHolder) {
        super.bind(holder)
        holder.title.text = module.name
        if (module.description != null) holder.desc.text = Html.fromHtml(module.description)
    }

    class SectionDocumentHolder : BaseEpoxyHolder() {
        val title by bind<TextView>(R.id.model_title)
        val desc by bind<TextView>(R.id.model_desc)
    }

}