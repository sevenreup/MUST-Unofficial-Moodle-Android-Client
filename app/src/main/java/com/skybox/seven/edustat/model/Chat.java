package com.skybox.seven.edustat.model;

import java.util.ArrayList;
import java.util.List;
import com.squareup.moshi.Json;

public class Chat {

    @Json(name = "id")
    private Integer id;
    @Json(name = "members")
    private List<Member> members = new ArrayList<>();
    @Json(name = "messages")
    private List<Message> messages = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}