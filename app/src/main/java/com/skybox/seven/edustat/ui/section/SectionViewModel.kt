package com.skybox.seven.edustat.ui.section

import android.content.Context
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liulishuo.okdownload.DownloadTask
import com.liulishuo.okdownload.UnifiedListenerManager
import com.liulishuo.okdownload.core.cause.EndCause
import com.skybox.seven.edustat.interfaces.DownloadCallbacks
import com.skybox.seven.edustat.model.*
import com.skybox.seven.edustat.repository.DownloadedFilesRepository
import com.skybox.seven.edustat.repository.PrefRepository
import com.skybox.seven.edustat.util.convertModuleToFile
import com.skybox.seven.edustat.util.download.MoodleDownloadListener
import com.skybox.seven.edustat.util.download.QueueController
import com.skybox.seven.edustat.util.download.TagUtil
import com.skybox.seven.edustat.util.notifyObserver
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.internal.notify

private const val TAG = "SectionViewModel"

class SectionViewModel @ViewModelInject constructor(
    private val manager: UnifiedListenerManager,
    private val repository: DownloadedFilesRepository,
    private val prefRepository: PrefRepository,
    private val compositeDisposable: CompositeDisposable
) : ViewModel(), DownloadCallbacks {

    val section: MutableLiveData<Section> = MutableLiveData()
    val modules: MutableLiveData<List<Module>> = MutableLiveData()
    lateinit var dbDownloads: LiveData<List<DownloadFile>>
    val downloadsMap: MutableLiveData<HashMap<String, DownloadFile>> = MutableLiveData(HashMap())
    private val moodleDownloadListener: MoodleDownloadListener = MoodleDownloadListener(this)

    fun downloadAll(context: Context, data: ActiveCourseData) {
        downloadsMap.value = QueueController.initTaskQueue(
            context, moodleDownloadListener, manager,
            downloadsMap.value!!, data.courseName!!, data.sectionName!!
        )
        repository.insert(downloadsMap.value!!.values)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e(TAG, "downloadAll: completed")
            }, {
                Log.e(TAG, "downloadAll: failed to insert", it)
            })
    }

    fun getDBDownloads(course: Int, section: Int): LiveData<List<DownloadFile>> {
        dbDownloads = repository.getSectionDownload(section, course)
        return dbDownloads
    }

    fun workOnModules(rawModules: List<Module>, data: ActiveCourseData) {
        val courseList: MutableList<Module> = ArrayList()
        val downloadMap: HashMap<String, DownloadFile> = HashMap()

        rawModules.forEach {
            if (it.modname == "resource") downloadMap[it.id.toString()] =
                convertModuleToFile(it, prefRepository, data)
            else courseList.add(it)
        }
        downloadsMap.value = downloadMap
        modules.value = courseList
    }


    override fun onDownloadTaskStart(task: DownloadTask) {
        val moduleID = TagUtil.getModuleID(task)
        if (moduleID != null) {
            val downloadComplete = downloadsMap.value?.get(moduleID.toString())
            if (downloadComplete != null) {
                downloadComplete.downloadStatus = DownloadStatus.DOWNLOADING
                downloadsMap.value?.set(downloadComplete.moduleId.toString(), downloadComplete)
                downloadsMap.notifyObserver()
            }
        }
    }

    override fun onDownloadTaskEnd(task: DownloadTask, cause: EndCause) {
        if (cause == EndCause.COMPLETED) {
            val moduleID = TagUtil.getModuleID(task)
            if (moduleID != null) {
                repository.updateDownloadStatus(moduleID, task.uri.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    // update ui regardless, scratch the exception
                    .subscribe({
                        complete(moduleID)
                    }, {
                        complete(moduleID)
                    })
            } else {
                // may have forgot to set tag
                Log.e(TAG, "onDownloadComplete: ${task.tag} does not have module ID set")
            }
        } else {
            val moduleID = TagUtil.getModuleID(task)
            val downloadComplete = downloadsMap.value?.get(moduleID.toString())
            
            if (downloadComplete != null) {
                downloadComplete.downloadStatus = DownloadStatus.FAILED
                downloadsMap.value?.set(downloadComplete.moduleId.toString(), downloadComplete)
                downloadsMap.notifyObserver()
            }
        }
    }

    override fun onDownloadTaskProgress(task: DownloadTask, offset: Long) {
        val moduleID = TagUtil.getModuleID(task)
        if (moduleID != null) {
            val downloadComplete = downloadsMap.value?.get(moduleID.toString())
            if (downloadComplete != null) {
                downloadComplete.downloadStatus = DownloadStatus.DOWNLOADING
                downloadComplete.progress = offset
                downloadsMap.value?.set(downloadComplete.moduleId.toString(), downloadComplete)
                downloadsMap.notifyObserver()
            }
        }
    }

    override fun onDownloadTaskConnected(
        task: DownloadTask,
        currentOffset: Long,
        totalLength: Long
    ) {
        // calculate stuff
    }


    override fun onDownloadTaskRetry(task: DownloadTask) {
    }

    private fun complete(moduleID: Int) {
        val downloadComplete = downloadsMap.value?.get(moduleID.toString())
        if (downloadComplete != null) {
            downloadComplete.downloaded = true
            downloadComplete.downloadStatus = DownloadStatus.COMPLETE
            downloadsMap.value?.set(downloadComplete.moduleId.toString(), downloadComplete)
            downloadsMap.notifyObserver()
        }
    }
}