package com.skybox.seven.edustat.epoxy.controllers

import com.airbnb.epoxy.Typed2EpoxyController
import com.skybox.seven.edustat.epoxy.conversations.UserChatModel_
import com.skybox.seven.edustat.model.Conversation

class ChatsController: Typed2EpoxyController<Boolean, List<Conversation>>() {
    override fun buildModels(loading: Boolean?, conversations: List<Conversation>?) {
        conversations?.forEach {
            // todo: find a safer way of extracting the info
            val username = it.members[0].fullname
            val lastMessage = it.messages[0].text
            val image = it.members[0].profileimageurlsmall

            UserChatModel_().id(it.id)
                .image(image)
                .lastMessage(lastMessage)
                .name(username)
                .listener {
                    _, _, _, position ->
                }.addTo(this)
        }
    }
}