package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

public class Role {

    @Json(name = "roleid")
    private Integer roleid;
    @Json(name = "name")
    private String name;
    @Json(name = "shortname")
    private String shortname;
    @Json(name = "sortorder")
    private Integer sortorder;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

}
