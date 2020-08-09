package com.skybox.seven.edustat.epoxy.controllers

import android.view.View
import com.airbnb.epoxy.Typed2EpoxyController
import com.skybox.seven.edustat.epoxy.conversations.UserChatModel_
import com.skybox.seven.edustat.model.Conversation
import com.skybox.seven.edustat.model.Member
import com.skybox.seven.edustat.util.DateHelper

private const val TAG = "ChatsController"

class ChatsController(private val callbacks: ChatsCallBack) : Typed2EpoxyController<Boolean, List<Conversation>>() {
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
                    .date(DateHelper.chatDateRelative(it.messages[0].timecreated))
                    .listener { _, _, view,_ -> callbacks.chatClicked(it.id,it.members[0], view)
                    }.addTo(this)
            }
        }
    }

    interface ChatsCallBack {
        fun chatClicked(id: Int, member: Member, view: View)
    }
}