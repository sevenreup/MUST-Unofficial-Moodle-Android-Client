package com.skybox.seven.edustat.model.prefs;

import com.squareup.moshi.Json;

public class NotificationProcessor {

    @Json(name = "displayname")
    private String displayname;
    @Json(name = "name")
    private String name;
    @Json(name = "locked")
    private Boolean locked;
    @Json(name = "userconfigured")
    private Integer userconfigured;
    @Json(name = "loggedin")
    private Loggedin loggedin;
    @Json(name = "loggedoff")
    private Loggedoff loggedoff;

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

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Integer getUserconfigured() {
        return userconfigured;
    }

    public void setUserconfigured(Integer userconfigured) {
        this.userconfigured = userconfigured;
    }

    public Loggedin getLoggedin() {
        return loggedin;
    }

    public void setLoggedin(Loggedin loggedin) {
        this.loggedin = loggedin;
    }

    public Loggedoff getLoggedoff() {
        return loggedoff;
    }

    public void setLoggedoff(Loggedoff loggedoff) {
        this.loggedoff = loggedoff;
    }

}
