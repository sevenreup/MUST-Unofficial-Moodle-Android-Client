package com.skybox.seven.edustat.api

import android.util.Log
import com.skybox.seven.edustat.repository.PrefRepository
import okhttp3.Interceptor
import okhttp3.Response

private const val TAG = "MoodleInterceptor"
class MoodleInterceptor(private var prefRepository: PrefRepository) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = prefRepository.getToken()
        Log.e(TAG, "intercept: $token")
        if (token != null) {
            val original = chain.request()
            val originalHttpUrl = original.url
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("wstoken", token)
                .addQueryParameter("moodlewsrestformat", "json")
                .build()

            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            return chain.proceed(request)
        }

        return chain.proceed(chain.request())
    }

}