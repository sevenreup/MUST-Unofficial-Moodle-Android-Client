package com.skybox.seven.edustat.model.prefs;

import com.squareup.moshi.Json;

public class Processor {

    @Json(name = "displayname")
    private String displayname;
    @Json(name = "name")
    private String name;
    @Json(name = "hassettings")
    private Boolean hassettings;
    @Json(name = "contextid")
    private Integer contextid;
    @Json(name = "userconfigured")
    private Integer userconfigured;

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHassettings() {
        return hassettings;
    }

    public void setHassettings(Boolean hassettings) {
        this.hassettings = hassettings;
    }

    public Integer getContextid() {
        return contextid;
    }

    public void setContextid(Integer contextid) {
        this.contextid = contextid;
    }

    public Integer getUserconfigured() {
        return userconfigured;
    }

    public void setUserconfigured(Integer userconfigured) {
        this.userconfigured = userconfigured;
    }

}
