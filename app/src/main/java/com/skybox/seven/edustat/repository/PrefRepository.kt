package com.skybox.seven.edustat.repository

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import com.skybox.seven.edustat.model.AuthResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject

private const val TAG = "PrefRepository"
class PrefRepository (private val prefs: SharedPreferences) {
    private val prefSubject = BehaviorSubject.createDefault(prefs)

    private var preferenceChangeListener = SharedPreferences.OnSharedPreferenceChangeListener {
        sharedPreferences, key ->
        prefSubject.onNext(sharedPreferences)
        Log.e(TAG, "prefs: $key")
    }

    init {
        prefs.registerOnSharedPreferenceChangeListener(preferenceChangeListener)
    }

    fun logout() {
        prefs.edit{
            ACCESS_TOKEN to null
            PRIVATE_TOKEN to null
        }
    }

    fun checkAuthState(): Boolean = prefs.getString(ACCESS_TOKEN, null) != null

    fun getFilePath():String? = prefs.getString(DOWNLOAD_FOLDER, null)

    fun saveFilePath(path: String):Completable = prefSubject.firstOrError().editSharedPreferences {
        putString(DOWNLOAD_FOLDER, path)
    }

    fun saveToken(authResponse: AuthResponse): Completable =
        prefSubject.firstOrError().editSharedPreferences{
            putString(ACCESS_TOKEN, authResponse.token)
            putString(PRIVATE_TOKEN, authResponse.privatetoken)
        }

    fun saveSiteUserID(site: Int): Completable = prefSubject.firstOrError().editSharedPreferences {
            putInt(USER_ID, site)

    }

    fun getUserID (): Int = prefs.getInt(USER_ID, 0)
    fun getToken (): String? = prefs.getString(ACCESS_TOKEN, null)

    fun Single<SharedPreferences>.editSharedPreferences(batch: SharedPreferences.Editor.() -> Unit): Completable =
        flatMapCompletable {
            Completable.fromAction {
                it.edit().also(batch).apply()
            }
        }

    fun Single<SharedPreferences>.clearSharedPreferences(batch: SharedPreferences.Editor.() -> Unit): Completable =
        flatMapCompletable {
            Completable.fromAction {
                it.edit().also(batch).apply()
            }
        }
    companion object {
        const val ACCESS_TOKEN = "MOODLE_TOKEN"
        const val PRIVATE_TOKEN = "MOODLE_PRIVATE_TOKEN"
        const val USER_ID = "MOODLE_SITE_USER_ID"
        const val PREFS = "MUST_MOODLE_SELF_ANDROID"
        const val DOWNLOAD_FOLDER = "MOODLE_DOWNLOAD_FOLDER"
    }
}