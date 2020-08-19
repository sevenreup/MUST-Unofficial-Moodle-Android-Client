package com.skybox.seven.edustat.util

import android.content.Context
import com.skybox.seven.edustat.repository.PrefRepository
import java.io.File
import java.net.URI

fun getParentFile(context: Context): File = context.externalCacheDir ?: context.cacheDir


fun addTokenToUrl(url: String, prefRepository: PrefRepository): String {
    val token = prefRepository.getToken()
    val uri = URI(url)
    val queryParams = StringBuilder(uri.query.orEmpty())
    if (queryParams.isNotEmpty())
        queryParams.append('&')

    queryParams.append("token=$token")
    return URI(uri.scheme, uri.authority, uri.path, queryParams.toString(), uri.fragment).toString()

}