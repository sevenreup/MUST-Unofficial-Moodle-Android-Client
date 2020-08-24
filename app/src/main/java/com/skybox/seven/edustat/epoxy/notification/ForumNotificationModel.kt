package com.skybox.seven.edustat.epoxy.notification

import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.airbnb.epoxy.preload.Preloadable
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder

@EpoxyModelClass(layout = R.layout.model_notification_forum)
abstract class ForumNotificationModel : EpoxyModelWithHolder<ForumNotificationHolder>(){
    @EpoxyAttribute lateinit var name: String
    @EpoxyAttribute lateinit var title: String
    @EpoxyAttribute lateinit var body: String
    @EpoxyAttribute lateinit var imageUrl: String
    @EpoxyAttribute lateinit var time: String
    @EpoxyAttribute var clickListener: View.OnClickListener? = null

    override fun getDefaultLayout(): Int = R.layout.model_notification_forum

    override fun createNewHolder(): ForumNotificationHolder = ForumNotificationHolder()

    override fun bind(holder: ForumNotificationHolder) {
        super.bind(holder)
        clickListener?.let { holder.setViewClickListener(it) }
        holder.title.text = title
        holder.body.text = Html.fromHtml(body)
    }
}

class ForumNotificationHolder: BaseEpoxyHolder() {
    val title by bind<TextView>(R.id.model_title)
    val userName by bind<TextView>(R.id.model_user)
    val body by bind<TextView>(R.id.model_body)
    val time by bind<TextView>(R.id.time)
    val image by bind<ImageView>(R.id.model_image)
}