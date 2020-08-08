package com.skybox.seven.edustat.epoxy.controllers

import com.airbnb.epoxy.Typed2EpoxyController
import com.skybox.seven.edustat.epoxy.conversations.UserChatModel_
import com.skybox.seven.edustat.model.Conversation

private const val TAG = "ChatsController"

class ChatsController : Typed2EpoxyController<Boolean, List<Conversation>>() {
    override fun buildModels(loading: Boolean?, conversations: List<Conversation>?) {

        conversations?.forEach {
            if (it.membercount > 1) {
                // todo: find a safer way of extracting the info (there is an error when its owners stuff because message is empty)
                val username = it.members[0].fullname
                val lastMessage = it.messages[0].text
                val image = it.members[0].profileimageurlsmall

                UserChatModel_().id(it.id)
                    .image(image)
                    .lastMessage(lastMessage)
                    .name(username)
                    .preloading(true)
                    .listener { _, _, _, position ->
                    }.addTo(this)
            }
        }
    }
}