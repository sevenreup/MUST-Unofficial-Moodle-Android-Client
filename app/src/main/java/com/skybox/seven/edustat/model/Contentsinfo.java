package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

import java.util.List;

public class Contentsinfo {

    @Json(name = "filescount")
    private Integer filescount;
    @Json(name = "filessize")
    private Integer filessize;
    @Json(name = "lastmodified")
    private Integer lastmodified;
    @Json(name = "mimetypes")
    private List<String> mimetypes = null;
    @Json(name = "repositorytype")
    private String repositorytype;

    public Integer getFilescount() {
        return filescount;
    }

    public void setFilescount(Integer filescount) {
        this.filescount = filescount;
    }

    public Integer getFilessize() {
        return filessize;
    }

    public void setFilessize(Integer filessize) {
        this.filessize = filessize;
    }

    public Integer getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Integer lastmodified) {
        this.lastmodified = lastmodified;
    }

    public List<String> getMimetypes() {
        return mimetypes;
    }

    public void setMimetypes(List<String> mimetypes) {
        this.mimetypes = mimetypes;
    }

    public String getRepositorytype() {
        return repositorytype;
    }

    public void setRepositorytype(String repositorytype) {
        this.repositorytype = repositorytype;
    }

}
