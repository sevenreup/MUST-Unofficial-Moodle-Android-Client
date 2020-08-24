package com.skybox.seven.edustat.model.prefs;

import com.squareup.moshi.Json;

public class Loggedoff {

    @Json(name = "name")
    private String name;
    @Json(name = "displayname")
    private String displayname;
    @Json(name = "checked")
    private Boolean checked;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

}
