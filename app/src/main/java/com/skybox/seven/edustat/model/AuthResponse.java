package com.skybox.seven.edustat.model;


import com.squareup.moshi.Json;

public class AuthResponse {

    @Json(name="token")
    private String token;

    @Json(name="privatetoken")
    private String privatetoken;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPrivatetoken() {
        return privatetoken;
    }

    public void setPrivatetoken(String privatetoken) {
        this.privatetoken = privatetoken;
    }

}