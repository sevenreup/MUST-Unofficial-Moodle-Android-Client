package com.skybox.seven.edustat.api

import com.skybox.seven.edustat.model.AuthResponse
import com.skybox.seven.edustat.model.Site
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoodleService {
    @GET("login/token.php?service=moodle_mobile_app")
    fun login(@Query("username") username: String, @Query("password") password: String): Single<AuthResponse>

    @GET("webservice/rest/server.php?wsfunction=core_webservice_get_site_info")
    fun getSite(): Single<Site>

    @GET("webservice/rest/server.php?wsfunction=core_enrol_get_users_courses")
    fun getCourses(@Query("userid") id: String)
}