package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

public class Enrolledcourse {

    @Json(name = "id")
    private Integer id;
    @Json(name = "fullname")
    private String fullname;
    @Json(name = "shortname")
    private String shortname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

}
