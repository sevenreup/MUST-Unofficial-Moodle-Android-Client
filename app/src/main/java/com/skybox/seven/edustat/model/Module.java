package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class Module {

    @Json(name = "id")
    private Integer id;
    @Json(name = "url")
    private String url;
    @Json(name = "name")
    private String name;
    @Json(name = "instance")
    private Integer instance;
    @Json(name = "description")
    private String description;
    @Json(name = "visible")
    private Integer visible;
    @Json(name = "uservisible")
    private Boolean uservisible;
    @Json(name = "visibleoncoursepage")
    private Integer visibleoncoursepage;
    @Json(name = "modicon")
    private String modicon;
    @Json(name = "modname")
    private String modname;
    @Json(name = "modplural")
    private String modplural;
    @Json(name = "indent")
    private Integer indent;
    @Json(name = "onclick")
    private String onclick;
    @Json(name = "afterlink")
    private Object afterlink;
    @Json(name = "customdata")
    private String customdata;
    @Json(name = "completion")
    private Integer completion;
    @Json(name = "completiondata")
    private Completiondata completiondata;
    @Json(name = "contents")
    private List<Content> contents = new ArrayList<>();
    @Json(name = "contentsinfo")
    private Contentsinfo contentsinfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInstance() {
        return instance;
    }

    public void setInstance(Integer instance) {
        this.instance = instance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Boolean getUservisible() {
        return uservisible;
    }

    public void setUservisible(Boolean uservisible) {
        this.uservisible = uservisible;
    }

    public Integer getVisibleoncoursepage() {
        return visibleoncoursepage;
    }

    public void setVisibleoncoursepage(Integer visibleoncoursepage) {
        this.visibleoncoursepage = visibleoncoursepage;
    }

    public String getModicon() {
        return modicon;
    }

    public void setModicon(String modicon) {
        this.modicon = modicon;
    }

    public String getModname() {
        return modname;
    }

    public void setModname(String modname) {
        this.modname = modname;
    }

    public String getModplural() {
        return modplural;
    }

    public void setModplural(String modplural) {
        this.modplural = modplural;
    }

    public Integer getIndent() {
        return indent;
    }

    public void setIndent(Integer indent) {
        this.indent = indent;
    }

    public String getOnclick() {
        return onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }

    public Object getAfterlink() {
        return afterlink;
    }

    public void setAfterlink(Object afterlink) {
        this.afterlink = afterlink;
    }

    public String getCustomdata() {
        return customdata;
    }

    public void setCustomdata(String customdata) {
        this.customdata = customdata;
    }

    public Integer getCompletion() {
        return completion;
    }

    public void setCompletion(Integer completion) {
        this.completion = completion;
    }

    public Completiondata getCompletiondata() {
        return completiondata;
    }

    public void setCompletiondata(Completiondata completiondata) {
        this.completiondata = completiondata;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public Contentsinfo getContentsinfo() {
        return contentsinfo;
    }

    public void setContentsinfo(Contentsinfo contentsinfo) {
        this.contentsinfo = contentsinfo;
    }

}
