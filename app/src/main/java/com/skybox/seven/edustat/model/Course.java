package com.skybox.seven.edustat.model;

import java.util.List;
import com.squareup.moshi.Json;

public class Course {

    @Json(name = "id")
    private Integer id;
    @Json(name = "shortname")
    private String shortname;
    @Json(name = "fullname")
    private String fullname;
    @Json(name = "displayname")
    private String displayname;
    @Json(name = "enrolledusercount")
    private Integer enrolledusercount;
    @Json(name = "idnumber")
    private String idnumber;
    @Json(name = "visible")
    private Integer visible;
    @Json(name = "summary")
    private String summary;
    @Json(name = "summaryformat")
    private Integer summaryformat;
    @Json(name = "format")
    private String format;
    @Json(name = "showgrades")
    private Boolean showgrades;
    @Json(name = "lang")
    private String lang;
    @Json(name = "enablecompletion")
    private Boolean enablecompletion;
    @Json(name = "completionhascriteria")
    private Boolean completionhascriteria;
    @Json(name = "completionusertracked")
    private Boolean completionusertracked;
    @Json(name = "category")
    private Integer category;
    @Json(name = "progress")
    private Integer progress;
    @Json(name = "completed")
    private Boolean completed;
    @Json(name = "startdate")
    private Integer startdate;
    @Json(name = "enddate")
    private Integer enddate;
    @Json(name = "marker")
    private Integer marker;
    @Json(name = "lastaccess")
    private Integer lastaccess;
    @Json(name = "isfavourite")
    private Boolean isfavourite;
    @Json(name = "hidden")
    private Boolean hidden;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public Integer getEnrolledusercount() {
        return enrolledusercount;
    }

    public void setEnrolledusercount(Integer enrolledusercount) {
        this.enrolledusercount = enrolledusercount;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Boolean getShowgrades() {
        return showgrades;
    }

    public void setShowgrades(Boolean showgrades) {
        this.showgrades = showgrades;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getEnablecompletion() {
        return enablecompletion;
    }

    public void setEnablecompletion(Boolean enablecompletion) {
        this.enablecompletion = enablecompletion;
    }

    public Boolean getCompletionhascriteria() {
        return completionhascriteria;
    }

    public void setCompletionhascriteria(Boolean completionhascriteria) {
        this.completionhascriteria = completionhascriteria;
    }

    public Boolean getCompletionusertracked() {
        return completionusertracked;
    }

    public void setCompletionusertracked(Boolean completionusertracked) {
        this.completionusertracked = completionusertracked;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getStartdate() {
        return startdate;
    }

    public void setStartdate(Integer startdate) {
        this.startdate = startdate;
    }

    public Integer getEnddate() {
        return enddate;
    }

    public void setEnddate(Integer enddate) {
        this.enddate = enddate;
    }

    public Integer getMarker() {
        return marker;
    }

    public void setMarker(Integer marker) {
        this.marker = marker;
    }

    public Integer getLastaccess() {
        return lastaccess;
    }

    public void setLastaccess(Integer lastaccess) {
        this.lastaccess = lastaccess;
    }

    public Boolean getIsfavourite() {
        return isfavourite;
    }

    public void setIsfavourite(Boolean isfavourite) {
        this.isfavourite = isfavourite;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

}