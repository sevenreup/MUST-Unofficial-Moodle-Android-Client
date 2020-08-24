package com.skybox.seven.edustat.model.prefs;

import com.squareup.moshi.Json;

import java.util.List;

public class NotificationPref {

    @Json(name = "displayname")
    private String displayname;
    @Json(name = "preferencekey")
    private String preferencekey;
    @Json(name = "processors")
    private List<NotificationProcessor> processors = null;

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getPreferencekey() {
        return preferencekey;
    }

    public void setPreferencekey(String preferencekey) {
        this.preferencekey = preferencekey;
    }

    public List<NotificationProcessor> getProcessors() {
        return processors;
    }

    public void setProcessors(List<NotificationProcessor> processors) {
        this.processors = processors;
    }

}
