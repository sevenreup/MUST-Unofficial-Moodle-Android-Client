package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

public class Notification {

    @Json(name = "id")
    private Integer id;
    @Json(name = "useridfrom")
    private Integer useridfrom;
    @Json(name = "useridto")
    private Integer useridto;
    @Json(name = "subject")
    private String subject;
    @Json(name = "shortenedsubject")
    private String shortenedsubject;
    @Json(name = "text")
    private String text;
    @Json(name = "fullmessage")
    private String fullmessage;
    @Json(name = "fullmessageformat")
    private Integer fullmessageformat;
    @Json(name = "fullmessagehtml")
    private String fullmessagehtml;
    @Json(name = "smallmessage")
    private String smallmessage;
    @Json(name = "contexturl")
    private String contexturl;
    @Json(name = "contexturlname")
    private String contexturlname;
    @Json(name = "timecreated")
    private Integer timecreated;
    @Json(name = "timecreatedpretty")
    private String timecreatedpretty;
    @Json(name = "timeread")
    private Integer timeread;
    @Json(name = "read")
    private Boolean read;
    @Json(name = "deleted")
    private Boolean deleted;
    @Json(name = "iconurl")
    private String iconurl;
    @Json(name = "component")
    private String component;
    @Json(name = "eventtype")
    private String eventtype;
    @Json(name = "customdata")
    private String customdata;

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

    public Integer getUseridto() {
        return useridto;
    }

    public void setUseridto(Integer useridto) {
        this.useridto = useridto;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getShortenedsubject() {
        return shortenedsubject;
    }

    public void setShortenedsubject(String shortenedsubject) {
        this.shortenedsubject = shortenedsubject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFullmessage() {
        return fullmessage;
    }

    public void setFullmessage(String fullmessage) {
        this.fullmessage = fullmessage;
    }

    public Integer getFullmessageformat() {
        return fullmessageformat;
    }

    public void setFullmessageformat(Integer fullmessageformat) {
        this.fullmessageformat = fullmessageformat;
    }

    public String getFullmessagehtml() {
        return fullmessagehtml;
    }

    public void setFullmessagehtml(String fullmessagehtml) {
        this.fullmessagehtml = fullmessagehtml;
    }

    public String getSmallmessage() {
        return smallmessage;
    }

    public void setSmallmessage(String smallmessage) {
        this.smallmessage = smallmessage;
    }

    public String getContexturl() {
        return contexturl;
    }

    public void setContexturl(String contexturl) {
        this.contexturl = contexturl;
    }

    public String getContexturlname() {
        return contexturlname;
    }

    public void setContexturlname(String contexturlname) {
        this.contexturlname = contexturlname;
    }

    public Integer getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Integer timecreated) {
        this.timecreated = timecreated;
    }

    public String getTimecreatedpretty() {
        return timecreatedpretty;
    }

    public void setTimecreatedpretty(String timecreatedpretty) {
        this.timecreatedpretty = timecreatedpretty;
    }

    public Integer getTimeread() {
        return timeread;
    }

    public void setTimeread(Integer timeread) {
        this.timeread = timeread;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public String getCustomdata() {
        return customdata;
    }

    public void setCustomdata(String customdata) {
        this.customdata = customdata;
    }

}
