package com.skybox.seven.edustat.model.prefs;

import com.squareup.moshi.Json;

import java.util.List;

public class Preferences {

    @Json(name = "userid")
    private Integer userid;
    @Json(name = "disableall")
    private Integer disableall;
    @Json(name = "processors")
    private List<Processor> processors = null;
    @Json(name = "components")
    private List<Component> components = null;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDisableall() {
        return disableall;
    }

    public void setDisableall(Integer disableall) {
        this.disableall = disableall;
    }

    public List<Processor> getProcessors() {
        return processors;
    }

    public void setProcessors(List<Processor> processors) {
        this.processors = processors;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

}
