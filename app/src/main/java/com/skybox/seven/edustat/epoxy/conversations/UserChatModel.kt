package com.skybox.seven.edustat.epoxy.conversations

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.airbnb.epoxy.preload.Preloadable
import com.bumptech.glide.Glide
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder
import com.skybox.seven.edustat.util.loadImage

@EpoxyModelClass(layout = R.layout.model_user_chat)
abstract class UserChatModel : EpoxyModelWithHolder<UserChatModel.UserChatHolder>() {
    @EpoxyAttribute lateinit var listener: View.OnClickListener
    @EpoxyAttribute lateinit var name: String
    @EpoxyAttribute lateinit var lastMessage: String
    @EpoxyAttribute lateinit var image: String
    @EpoxyAttribute
    var preloading: Boolean = false

    class UserChatHolder: BaseEpoxyHolder(), Preloadable {
        private val image by bind<ImageView>(R.id.user_image)
        val username by bind<TextView>(R.id.user_name)
        val lastMessage by bind<TextView>(R.id.last_message)
        override val viewsToPreload by lazy { listOf(image) }
        val glide by lazy { Glide.with(image) }
    }

    override fun bind(holder: UserChatHolder) {
        super.bind(holder)
        holder.username.text = name
        holder.lastMessage.text = lastMessage
        holder.glide.loadImage(image, preloading)
        holder.setViewClickListener(listener)
    }

    override fun getDefaultLayout(): Int = R.layout.model_user_chat

    override fun createNewHolder(): UserChatHolder = UserChatHolder()
}