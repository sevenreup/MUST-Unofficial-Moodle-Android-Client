package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

public class Customfield {

    @Json(name = "type")
    private String type;
    @Json(name = "value")
    private String value;
    @Json(name = "name")
    private String name;
    @Json(name = "shortname")
    private String shortname;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

}
