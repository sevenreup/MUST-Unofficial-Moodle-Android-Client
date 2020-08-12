package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

public class Content {

    @Json(name = "type")
    private String type;
    @Json(name = "filename")
    private String filename;
    @Json(name = "filepath")
    private String filepath;
    @Json(name = "filesize")
    private Integer filesize;
    @Json(name = "fileurl")
    private String fileurl;
    @Json(name = "timecreated")
    private Integer timecreated;
    @Json(name = "timemodified")
    private Integer timemodified;
    @Json(name = "sortorder")
    private Integer sortorder;
    @Json(name = "userid")
    private Integer userid;
    @Json(name = "author")
    private String author;
    @Json(name = "license")
    private String license;
    @Json(name = "mimetype")
    private String mimetype;
    @Json(name = "isexternalfile")
    private Boolean isexternalfile;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public Integer getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Integer timecreated) {
        this.timecreated = timecreated;
    }

    public Integer getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(Integer timemodified) {
        this.timemodified = timemodified;
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public Boolean getIsexternalfile() {
        return isexternalfile;
    }

    public void setIsexternalfile(Boolean isexternalfile) {
        this.isexternalfile = isexternalfile;
    }

}
