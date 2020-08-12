package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

public class Completiondata {

    @Json(name = "state")
    private Integer state;
    @Json(name = "timecompleted")
    private Integer timecompleted;
    @Json(name = "overrideby")
    private Object overrideby;
    @Json(name = "valueused")
    private Boolean valueused;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTimecompleted() {
        return timecompleted;
    }

    public void setTimecompleted(Integer timecompleted) {
        this.timecompleted = timecompleted;
    }

    public Object getOverrideby() {
        return overrideby;
    }

    public void setOverrideby(Object overrideby) {
        this.overrideby = overrideby;
    }

    public Boolean getValueused() {
        return valueused;
    }

    public void setValueused(Boolean valueused) {
        this.valueused = valueused;
    }

}
