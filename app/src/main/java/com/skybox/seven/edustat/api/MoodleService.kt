package com.skybox.seven.edustat.api

import com.skybox.seven.edustat.api.response.AuthResponse
import io.reactivex.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoodleService {
    @GET("login/token.php")
    fun login(@Query("username") username: String, @Query("password") password: String): Single<AuthResponse>
}