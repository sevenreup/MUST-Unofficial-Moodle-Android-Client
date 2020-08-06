package com.skybox.seven.edustat.api

import retrofit2.http.GET
import retrofit2.http.Query

interface MoodleService {
    @GET("login/token.php")
    fun login(@Query("username") username: String, @Query("password") password: String)
}