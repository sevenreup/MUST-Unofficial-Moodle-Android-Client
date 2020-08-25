package com.skybox.seven.edustat.util

import android.content.Context
import android.content.Intent
import android.os.Environment
import androidx.core.content.FileProvider
import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimap
import com.skybox.seven.edustat.model.ActiveCourseData
import com.skybox.seven.edustat.model.DownloadFile
import com.skybox.seven.edustat.model.Module
import com.skybox.seven.edustat.model.Notification
import com.skybox.seven.edustat.repository.PrefRepository
import java.io.File
import java.net.URI

fun getParentFile(context: Context): File?  = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS) ?: context.filesDir

fun addTokenToUrl(url: String, prefRepository: PrefRepository): String {
    val token = prefRepository.getToken()
    val uri = URI(url)
    val queryParams = StringBuilder(uri.query.orEmpty())
    if (queryParams.isNotEmpty())
        queryParams.append('&')

    queryParams.append("token=$token")
    return URI(uri.scheme, uri.authority, uri.path, queryParams.toString(), uri.fragment).toString()

}

fun addTokenToUrl(url: String, token: String): String {
    val uri = URI(url)
    val queryParams = StringBuilder(uri.query.orEmpty())
    if (queryParams.isNotEmpty())
        queryParams.append('&')

    queryParams.append("token=$token")
    return URI(uri.scheme, uri.authority, uri.path, queryParams.toString(), uri.fragment).toString()

}


fun convertModuleToFile(module: Module, prefRepository: PrefRepository, data: ActiveCourseData): DownloadFile {
    val file = DownloadFile()
    file.moduleId = module.id
    file.fileUrl = addTokenToUrl(module.contents[0].fileurl, prefRepository)
    file.mimeType = module.contents[0].mimetype
    file.filename = module.contents[0].filename
    file.fileSize = module.contents[0].filesize
    file.description = module.description
    file.courseId = data.courseId
    file.sectionId = data.sectionID
    return file
}

fun selfFileOpenIntent(context: Context, path: String, mimeType: String, packageName: String): Intent {
    val intent = Intent(Intent.ACTION_VIEW)
    val fileOpen = File(URI.create(path))
    val uri = FileProvider.getUriForFile(context, "${packageName}.fileprovider", fileOpen)
    intent.setDataAndType(uri, mimeType)
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    return intent
}

fun getUserIdsFromNotification(notifications: List<Notification>): List<Int> = notifications.map { it.useridfrom  }

fun createMapOfNotifications(notifications: List<Notification>): Multimap<String, Notification> {
    val maps:Multimap<String, Notification> = ArrayListMultimap.create()
    notifications.forEach {
        maps.put(it.useridfrom.toString(), it)
    }
    return maps
}