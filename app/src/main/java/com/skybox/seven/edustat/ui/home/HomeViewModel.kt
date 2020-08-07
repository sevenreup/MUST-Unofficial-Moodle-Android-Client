package com.skybox.seven.edustat.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skybox.seven.edustat.api.MoodleService
import com.skybox.seven.edustat.model.Course
import com.skybox.seven.edustat.model.Site
import com.skybox.seven.edustat.repository.PrefRepository
import com.skybox.seven.edustat.repository.SiteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel @ViewModelInject constructor(private val moodleService: MoodleService,
                                                 private val siteRepository: SiteRepository,
                                                 private val prefRepository: PrefRepository
):
    ViewModel() {
    val courseList: MutableLiveData<List<Course>> = MutableLiveData()
    val siteInfo: LiveData<Site> = siteRepository.getSite(prefRepository.getSite())

    fun getCourseList(userId: Int) {
        moodleService.getCourses(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                courseList.value = it
            }, {
                it.printStackTrace()
            })
    }
}