package com.skybox.seven.edustat.model

import com.squareup.moshi.Json

class UserProfileRequests(
    @Json(name = "userid") userID: Int,
    @Json(name = "courseid") courseID: Int
)