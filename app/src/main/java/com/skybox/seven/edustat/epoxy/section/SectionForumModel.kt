package com.skybox.seven.edustat.epoxy.section

import android.text.Html
import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder
import com.skybox.seven.edustat.model.Module

@EpoxyModelClass(layout = R.layout.model_section_forum)
abstract class SectionForumModel : EpoxyModelWithHolder<SectionForumModel.SelectionForumHolder>() {
    @EpoxyAttribute
    lateinit var module: Module

    @EpoxyAttribute
    var listener: View.OnClickListener? = null

    override fun getDefaultLayout(): Int = R.layout.model_section_forum

    override fun createNewHolder(): SelectionForumHolder = SelectionForumHolder()

    override fun bind(holder: SelectionForumHolder) {
        super.bind(holder)
        holder.title.text = module.name
        if (module.description != null) holder.desc.text = Html.fromHtml(module.description)
    }

    class SelectionForumHolder : BaseEpoxyHolder() {
        val title by bind<TextView>(R.id.model_title)
        val desc by bind<TextView>(R.id.model_desc)
    }
}