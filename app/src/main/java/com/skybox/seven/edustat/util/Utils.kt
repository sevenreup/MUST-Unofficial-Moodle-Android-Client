package com.skybox.seven.edustat.util

import android.content.Context
import android.os.Environment
import com.skybox.seven.edustat.model.ActiveCourseData
import com.skybox.seven.edustat.model.DownloadFile
import com.skybox.seven.edustat.model.Module
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