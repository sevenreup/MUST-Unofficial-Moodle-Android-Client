package com.skybox.seven.edustat.model;

import com.squareup.moshi.Json;

import java.util.List;

public class Conversation {

    @Json(name = "id")
    private Integer id;
    @Json(name = "name")
    private String name;
    @Json(name = "subname")
    private Object subname;
    @Json(name = "imageurl")
    private Object imageurl;
    @Json(name = "type")
    private Integer type;
    @Json(name = "membercount")
    private Integer membercount;
    @Json(name = "ismuted")
    private Boolean ismuted;
    @Json(name = "isfavourite")
    private Boolean isfavourite;
    @Json(name = "isread")
    private Boolean isread;
    @Json(name = "unreadcount")
    private Object unreadcount;
    @Json(name = "members")
    private List<Member> members = null;
    @Json(name = "messages")
    private List<Message> messages = null;
    @Json(name = "candeletemessagesforallusers")
    private Boolean candeletemessagesforallusers;

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

    public Object getSubname() {
        return subname;
    }

    public void setSubname(Object subname) {
        this.subname = subname;
    }

    public Object getImageurl() {
        return imageurl;
    }

    public void setImageurl(Object imageurl) {
        this.imageurl = imageurl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMembercount() {
        return membercount;
    }

    public void setMembercount(Integer membercount) {
        this.membercount = membercount;
    }

    public Boolean getIsmuted() {
        return ismuted;
    }

    public void setIsmuted(Boolean ismuted) {
        this.ismuted = ismuted;
    }

    public Boolean getIsfavourite() {
        return isfavourite;
    }

    public void setIsfavourite(Boolean isfavourite) {
        this.isfavourite = isfavourite;
    }

    public Boolean getIsread() {
        return isread;
    }

    public void setIsread(Boolean isread) {
        this.isread = isread;
    }

    public Object getUnreadcount() {
        return unreadcount;
    }

    public void setUnreadcount(Object unreadcount) {
        this.unreadcount = unreadcount;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Boolean getCandeletemessagesforallusers() {
        return candeletemessagesforallusers;
    }

    public void setCandeletemessagesforallusers(Boolean candeletemessagesforallusers) {
        this.candeletemessagesforallusers = candeletemessagesforallusers;
    }

}
