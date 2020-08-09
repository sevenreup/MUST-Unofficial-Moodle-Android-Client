package com.skybox.seven.edustat.epoxy.conversations

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.google.android.material.chip.Chip
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder

@EpoxyModelClass(layout = R.layout.model_message_date)
abstract class MessageDateModel :EpoxyModelWithHolder<MessageDateModel.MessageDateHolder>() {
    @EpoxyAttribute lateinit var date: String

    class MessageDateHolder: BaseEpoxyHolder() {
        val date by bind<Chip>(R.id.date)
    }

    override fun bind(holder: MessageDateHolder) {
        super.bind(holder)
        holder.date.text = date
    }

    override fun getDefaultLayout(): Int = R.layout.model_message_date

    override fun createNewHolder(): MessageDateHolder = MessageDateHolder()
}