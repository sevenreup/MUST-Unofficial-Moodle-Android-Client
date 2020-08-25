 package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

import java.util.List;


 public class UserResponse {

    @Json(name = "id")
    private Integer id;
    @Json(name = "fullname")
    private String fullname;
    @Json(name = "email")
    private String email;
    @Json(name = "firstaccess")
    private Integer firstaccess;
    @Json(name = "lastaccess")
    private Integer lastaccess;
    @Json(name = "suspended")
    private Boolean suspended;
    @Json(name = "description")
    private String description;
    @Json(name = "descriptionformat")
    private Integer descriptionformat;
    @Json(name = "city")
    private String city;
    @Json(name = "profileimageurlsmall")
    private String profileimageurlsmall;
    @Json(name = "profileimageurl")
    private String profileimageurl;
    @Json(name = "customfields")
    private List<Customfield> customfields = null;
    @Json(name = "roles")
    private List<Role> roles = null;
    @Json(name = "enrolledcourses")
    private List<Enrolledcourse> enrolledcourses = null;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFirstaccess() {
        return firstaccess;
    }

    public void setFirstaccess(Integer firstaccess) {
        this.firstaccess = firstaccess;
    }

    public Integer getLastaccess() {
        return lastaccess;
    }

    public void setLastaccess(Integer lastaccess) {
        this.lastaccess = lastaccess;
    }

    public Boolean getSuspended() {
        return suspended;
    }

    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDescriptionformat() {
        return descriptionformat;
    }

    public void setDescriptionformat(Integer descriptionformat) {
        this.descriptionformat = descriptionformat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProfileimageurlsmall() {
        return profileimageurlsmall;
    }

    public void setProfileimageurlsmall(String profileimageurlsmall) {
        this.profileimageurlsmall = profileimageurlsmall;
    }

    public String getProfileimageurl() {
        return profileimageurl;
    }

    public void setProfileimageurl(String profileimageurl) {
        this.profileimageurl = profileimageurl;
    }

    public List<Customfield> getCustomfields() {
        return customfields;
    }

    public void setCustomfields(List<Customfield> customfields) {
        this.customfields = customfields;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Enrolledcourse> getEnrolledcourses() {
        return enrolledcourses;
    }

    public void setEnrolledcourses(List<Enrolledcourse> enrolledcourses) {
        this.enrolledcourses = enrolledcourses;
    }

}