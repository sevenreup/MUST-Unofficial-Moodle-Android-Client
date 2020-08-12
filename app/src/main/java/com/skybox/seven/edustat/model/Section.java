package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class Section {

    @Json(name = "id")
    private Integer id;
    @Json(name = "name")
    private String name;
    @Json(name = "visible")
    private Integer visible;
    @Json(name = "summary")
    private String summary;
    @Json(name = "summaryformat")
    private Integer summaryformat;
    @Json(name = "section")
    private Integer section;
    @Json(name = "hiddenbynumsections")
    private Integer hiddenbynumsections;
    @Json(name = "uservisible")
    private Boolean uservisible;
    @Json(name = "modules")
    private List<Module> modules = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getSummaryformat() {
        return summaryformat;
    }

    public void setSummaryformat(Integer summaryformat) {
        this.summaryformat = summaryformat;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Integer getHiddenbynumsections() {
        return hiddenbynumsections;
    }

    public void setHiddenbynumsections(Integer hiddenbynumsections) {
        this.hiddenbynumsections = hiddenbynumsections;
    }

    public Boolean getUservisible() {
        return uservisible;
    }

    public void setUservisible(Boolean uservisible) {
        this.uservisible = uservisible;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

}