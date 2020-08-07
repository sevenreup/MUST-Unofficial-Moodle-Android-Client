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


    fun saveToken(authResponse: AuthResponse): Completable =
        prefSubject.firstOrError().editSharedPreferences{
            putString(ACCESS_TOKEN, authResponse.token)
            putString(PRIVATE_TOKEN, authResponse.privatetoken)
        }

    fun saveSite(site: Int): Completable = prefSubject.firstOrError().editSharedPreferences {
            putInt(SITE_ID, site)

    }

    fun getSite (): Int = prefs.getInt(SITE_ID, 0)
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
        const val SITE_ID = "MOODLE_SITE_USER_ID"
        const val PREFS = "MUST_MOODLE_SELF_ANDROID"
    }
}