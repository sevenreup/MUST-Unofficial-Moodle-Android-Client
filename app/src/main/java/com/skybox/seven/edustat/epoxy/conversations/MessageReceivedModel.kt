package com.skybox.seven.edustat.epoxy.conversations

import android.text.Html
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder

@EpoxyModelClass(layout = R.layout.model_message_received)
abstract class MessageReceivedModel: EpoxyModelWithHolder<MessageReceivedModel.MessageReceivedHolder>() {
    @EpoxyAttribute lateinit var text: String
    @EpoxyAttribute lateinit var time: String

    class MessageReceivedHolder: BaseEpoxyHolder() {
        val message by bind<TextView>(R.id.message)
        val time by bind<TextView>(R.id.time)
    }

    override fun getDefaultLayout(): Int =  R.layout.model_message_received

    override fun createNewHolder(): MessageReceivedHolder = MessageReceivedHolder()

    override fun bind(holder: MessageReceivedHolder) {
        super.bind(holder)
        holder.message.text = Html.fromHtml(text)
        holder.time.text = time
    }
}