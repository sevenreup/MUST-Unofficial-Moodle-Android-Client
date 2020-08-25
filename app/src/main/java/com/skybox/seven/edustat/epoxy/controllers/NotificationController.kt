package com.skybox.seven.edustat.epoxy.controllers

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.skybox.seven.edustat.epoxy.generic.LoadingModel_
import com.skybox.seven.edustat.epoxy.notification.ForumNotificationModel_
import com.skybox.seven.edustat.model.Notification

class NotificationController(private val token: String): PagedListEpoxyController<Notification>() {
    init {
        isDebugLoggingEnabled = true
    }

    override fun buildItemModel(currentPosition: Int, item: Notification?): EpoxyModel<*> {
        return if (item != null) {
            ForumNotificationModel_().id(item.id)
                .body(item.smallmessage)
                .user(item.user)
                .token(token)
                .title(item.subject)
        } else {
            LoadingModel_().id("loading_")
        }
    }

}