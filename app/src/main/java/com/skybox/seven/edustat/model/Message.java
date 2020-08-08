package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

public class Message {

    @Json(name = "id")
    private Integer id;
    @Json(name = "useridfrom")
    private Integer useridfrom;
    @Json(name = "text")
    private String text;
    @Json(name = "timecreated")
    private Integer timecreated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUseridfrom() {
        return useridfrom;
    }

    public void setUseridfrom(Integer useridfrom) {
        this.useridfrom = useridfrom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Integer timecreated) {
        this.timecreated = timecreated;
    }

}
