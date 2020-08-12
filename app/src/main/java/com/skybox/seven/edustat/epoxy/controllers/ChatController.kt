package com.skybox.seven.edustat.epoxy.controllers

import com.airbnb.epoxy.Typed2EpoxyController
import com.skybox.seven.edustat.epoxy.conversations.MessageDateModel_
import com.skybox.seven.edustat.epoxy.conversations.MessageSelfModel_
import com.skybox.seven.edustat.model.Message
import com.skybox.seven.edustat.util.DateHelper
import java.util.*

class ChatController(private val userId: Int): Typed2EpoxyController<Boolean, List<Message>>() {
    private var lastDate: Date? = null

    override fun buildModels(loading: Boolean, messages: List<Message>) {
        messages.forEach {
                message ->
            val date = Date(message.timecreated.toLong() * 1000)

            MessageSelfModel_()
                .id(message.id)
                .text(message.text)
                .time(DateHelper.getTime(date))
                .self(userId == message.useridfrom)
                .addTo(this)
            addDateSeparator(date)
        }
    }

    private fun addDateSeparator(date: Date) {
        if (lastDate != null) {
            if (!DateHelper.checkIfSameDate(date, lastDate!!)) {
                MessageDateModel_()
                    .id(date.toString())
                    .date(DateHelper.convertToRelative(date))
                    .addTo(this)
            }
        }
        lastDate = date
    }
}