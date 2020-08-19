package com.skybox.seven.edustat.ui.section

import android.content.Context
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liulishuo.okdownload.UnifiedListenerManager
import com.skybox.seven.edustat.model.DownloadFile
import com.skybox.seven.edustat.model.Module
import com.skybox.seven.edustat.model.Section
import com.skybox.seven.edustat.repository.DownloadedFilesRepository
import com.skybox.seven.edustat.repository.PrefRepository
import com.skybox.seven.edustat.util.addTokenToUrl
import com.skybox.seven.edustat.util.download.MoodleDownloadListener
import com.skybox.seven.edustat.util.download.QueueController

class SectionViewModel @ViewModelInject constructor(private val manager: UnifiedListenerManager,
                                                    private val repository: DownloadedFilesRepository,
                                                    private val prefRepository: PrefRepository): ViewModel() {
    val section: MutableLiveData<Section> = MutableLiveData()
    val modules: MutableLiveData<List<Module>> = MutableLiveData()

    fun downloadAll(context: Context) {
        val files: MutableList<DownloadFile> = ArrayList()
        modules.value?.forEach {
            if(it.modname == "resource") {
                val file = DownloadFile()
                file.moduleId = it.id
                file.fileUrl = addTokenToUrl(it.contents[0].fileurl, prefRepository)
                file.mimeType = it.contents[0].mimetype
                file.filename = it.contents[0].filename
                file.fileSize = it.contents[0].filesize
                files.add(file)
            }
        }
        QueueController.initTaskQueue(context, MoodleDownloadListener(), manager, files, "one", "two",repository)
        Log.i("TAG", "downloadAll: ${files.size}")
    }
}