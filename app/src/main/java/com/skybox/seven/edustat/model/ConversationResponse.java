package com.skybox.seven.edustat.model;

import java.util.ArrayList;
import java.util.List;
import com.squareup.moshi.Json;

public class ConversationResponse {

    @Json(name = "conversations")
    private List<Conversation> conversations = new ArrayList<>();

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }

}


