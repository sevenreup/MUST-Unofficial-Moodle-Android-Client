package com.skybox.seven.edustat.model.prefs;

import com.squareup.moshi.Json;

import java.util.List;

public class Component {

    @Json(name = "displayname")
    private String displayname;
    @Json(name = "notifications")
    private List<NotificationPref> notificationPrefs = null;

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public List<NotificationPref> getNotificationPrefs() {
        return notificationPrefs;
    }

    public void setNotificationPrefs(List<NotificationPref> notificationPrefs) {
        this.notificationPrefs = notificationPrefs;
    }

}
