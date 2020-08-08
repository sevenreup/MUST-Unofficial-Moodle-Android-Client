package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

import java.util.List;

public class Member {

    @Json(name = "id")
    private Integer id;
    @Json(name = "fullname")
    private String fullname;
    @Json(name = "profileurl")
    private String profileurl;
    @Json(name = "profileimageurl")
    private String profileimageurl;
    @Json(name = "profileimageurlsmall")
    private String profileimageurlsmall;
    @Json(name = "isonline")
    private Boolean isonline;
    @Json(name = "showonlinestatus")
    private Boolean showonlinestatus;
    @Json(name = "isblocked")
    private Boolean isblocked;
    @Json(name = "iscontact")
    private Boolean iscontact;
    @Json(name = "isdeleted")
    private Boolean isdeleted;
    @Json(name = "canmessage")
    private Object canmessage;
    @Json(name = "requirescontact")
    private Object requirescontact;
    @Json(name = "contactrequests")
    private List<Object> contactrequests = null;

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

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getProfileimageurl() {
        return profileimageurl;
    }

    public void setProfileimageurl(String profileimageurl) {
        this.profileimageurl = profileimageurl;
    }

    public String getProfileimageurlsmall() {
        return profileimageurlsmall;
    }

    public void setProfileimageurlsmall(String profileimageurlsmall) {
        this.profileimageurlsmall = profileimageurlsmall;
    }

    public Boolean getIsonline() {
        return isonline;
    }

    public void setIsonline(Boolean isonline) {
        this.isonline = isonline;
    }

    public Boolean getShowonlinestatus() {
        return showonlinestatus;
    }

    public void setShowonlinestatus(Boolean showonlinestatus) {
        this.showonlinestatus = showonlinestatus;
    }

    public Boolean getIsblocked() {
        return isblocked;
    }

    public void setIsblocked(Boolean isblocked) {
        this.isblocked = isblocked;
    }

    public Boolean getIscontact() {
        return iscontact;
    }

    public void setIscontact(Boolean iscontact) {
        this.iscontact = iscontact;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Object getCanmessage() {
        return canmessage;
    }

    public void setCanmessage(Object canmessage) {
        this.canmessage = canmessage;
    }

    public Object getRequirescontact() {
        return requirescontact;
    }

    public void setRequirescontact(Object requirescontact) {
        this.requirescontact = requirescontact;
    }

    public List<Object> getContactrequests() {
        return contactrequests;
    }

    public void setContactrequests(List<Object> contactrequests) {
        this.contactrequests = contactrequests;
    }

}
