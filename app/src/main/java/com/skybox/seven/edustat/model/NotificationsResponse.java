
package com.skybox.seven.edustat.model;

import java.util.List;

import com.squareup.moshi.Json;

public class NotificationsResponse {

    @Json(name = "notifications")
    private List<Notification> notifications = null;
    @Json(name = "unreadcount")
    private Integer unreadcount;

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public Integer getUnreadcount() {
        return unreadcount;
    }

    public void setUnreadcount(Integer unreadcount) {
        this.unreadcount = unreadcount;
    }

}