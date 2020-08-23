package com.skybox.seven.edustat.epoxy.section

import android.content.res.ColorStateList
import android.graphics.Color
import android.text.Html
import android.view.View
import android.widget.TextView
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder
import com.skybox.seven.edustat.model.DownloadStatus

@EpoxyModelClass(layout = R.layout.model_section_document)
abstract class SectionDocumentModel :
    EpoxyModelWithHolder<SectionDocumentModel.SectionDocumentHolder>() {
    @EpoxyAttribute
    var clickListener: View.OnClickListener? = null
    @EpoxyAttribute
    lateinit var filename: String
    @EpoxyAttribute
    var progress: Long = 0L
    @EpoxyAttribute
    lateinit var downloadStatus: DownloadStatus
    @EpoxyAttribute
    var description: String? = null


    override fun getDefaultLayout(): Int = R.layout.model_section_document

    override fun createNewHolder(): SectionDocumentHolder = SectionDocumentHolder()

    override fun bind(holder: SectionDocumentHolder) {
        super.bind(holder)
        clickListener?.let { holder.setViewClickListener(it) }
        holder.title.text = filename
        if (description != null) holder.desc.text = Html.fromHtml(description)
        when(downloadStatus) {
            DownloadStatus.COMPLETE, DownloadStatus.DOWNLOADED -> {
                holder.progressHolder.visibility = View.GONE
                holder.dot.visibility = View.VISIBLE
                holder.dot.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
            }
            DownloadStatus.DOWNLOADING, DownloadStatus.RETRY -> {
                holder.progressHolder.visibility = View.VISIBLE
                holder.progress.setCurrentProgress(progress.toDouble())
                holder.status.text = downloadStatus.name.decapitalize()
                holder.dot.visibility = View.GONE
            }
            DownloadStatus.FAILED -> {
                holder.progress.progressColor = Color.RED
                holder.progressHolder.visibility = View.VISIBLE
                holder.progress.setCurrentProgress(progress.toDouble())
                holder.status.text = downloadStatus.name.decapitalize()
                holder.dot.visibility = View.GONE
            }
             else -> {
                 holder.progressHolder.visibility = View.GONE
                 holder.dot.visibility = View.VISIBLE
                 holder.dot.backgroundTintList = ColorStateList.valueOf(Color.RED)
             }
        }
    }

    class SectionDocumentHolder : BaseEpoxyHolder() {
        val title by bind<TextView>(R.id.model_title)
        val desc by bind<TextView>(R.id.model_desc)
        val status by bind<TextView>(R.id.model_status)
        val progress by bind<CircularProgressIndicator>(R.id.model_progress)
        val progressHolder by bind<View>(R.id.download_holder)
        val dot by bind<View>(R.id.dot_download)
    }

}