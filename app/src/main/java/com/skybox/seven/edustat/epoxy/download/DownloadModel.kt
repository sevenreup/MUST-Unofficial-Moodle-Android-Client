package com.skybox.seven.edustat.epoxy.download

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder
import com.skybox.seven.edustat.model.DownloadFile

@EpoxyModelClass(layout = R.layout.model_download_item)
abstract class DownloadModel: EpoxyModelWithHolder<DownloadModel.DownloadHolder>() {
    @EpoxyAttribute lateinit var file: DownloadFile

    class DownloadHolder: BaseEpoxyHolder() {
        val name by bind<TextView>(R.id.name)
    }

    override fun getDefaultLayout(): Int = R.layout.model_download_item

    override fun createNewHolder(): DownloadHolder = DownloadHolder()

    override fun bind(holder: DownloadHolder) {
        super.bind(holder)
        holder.name.text = file.filename
    }
}