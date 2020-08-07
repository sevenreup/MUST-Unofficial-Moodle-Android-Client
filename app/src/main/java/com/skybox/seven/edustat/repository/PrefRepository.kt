package com.skybox.seven.edustat.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.skybox.seven.edustat.api.response.AuthResponse

class PrefRepository (private val prefs: SharedPreferences) {
    private var _authToken: String? = prefs.getString(ACCESS_TOKEN, null)

    var authToken = _authToken

    fun logout() {
        prefs.edit{
            ACCESS_TOKEN to null
            PRIVATE_TOKEN to null
        }
        authToken = null
    }

    fun saveToken(authResponse: AuthResponse) {
        prefs.edit{
            putString(ACCESS_TOKEN, authResponse.token)
            putString(PRIVATE_TOKEN, authResponse.privatetoken)
        }
    }

    companion object {
        const val ACCESS_TOKEN = "MOODLE_TOKEN"
        const val PRIVATE_TOKEN = "MOODLE_PRIVATE_TOKEN"
        const val PREFS = "MUST_MOODLE_SELF_ANDROID"
    }
}