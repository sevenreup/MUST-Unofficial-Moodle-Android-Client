package com.skybox.seven.edustat.ui.section

import android.content.Context
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liulishuo.okdownload.UnifiedListenerManager
import com.skybox.seven.edustat.model.ActiveCourseData
import com.skybox.seven.edustat.model.DownloadFile
import com.skybox.seven.edustat.model.Module
import com.skybox.seven.edustat.model.Section
import com.skybox.seven.edustat.repository.DownloadedFilesRepository
import com.skybox.seven.edustat.repository.PrefRepository
import com.skybox.seven.edustat.util.convertModuleToFile
import com.skybox.seven.edustat.util.download.MoodleDownloadListener
import com.skybox.seven.edustat.util.download.QueueController
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

private const val TAG = "SectionViewModel"
class SectionViewModel @ViewModelInject constructor(private val manager: UnifiedListenerManager,
                                                    private val repository: DownloadedFilesRepository,
                                                    private val prefRepository: PrefRepository,
                                                    private val moodleDownloadListener: MoodleDownloadListener): ViewModel() {
    val section: MutableLiveData<Section> = MutableLiveData()
    val modules: MutableLiveData<List<Module>> = MutableLiveData()
    val downloadable: MutableLiveData<List<DownloadFile>> = MutableLiveData(ArrayList())

    fun downloadAll(context: Context, data: ActiveCourseData) {
        downloadable.value = QueueController.initTaskQueue(context, moodleDownloadListener, manager,
            downloadable.value!!, data.courseName!!, data.sectionName!!)
        repository.insert(downloadable.value!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e(TAG, "downloadAll: completed")
            }, {
                Log.e(TAG, "downloadAll: failed to insert", it)
            })
    }

    fun workOnModules(rawModules: List<Module>, data:ActiveCourseData) {
        val downloadList: MutableList<DownloadFile> = ArrayList()
        val courseList: MutableList<Module> = ArrayList()
        rawModules.forEach {
            if (it.modname == "resource") downloadList.add(convertModuleToFile(it, prefRepository, data))
            else courseList.add(it)
        }
        downloadable.value = downloadList
        modules.value = courseList
    }


}