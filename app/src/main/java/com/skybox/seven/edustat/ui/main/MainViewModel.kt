package com.skybox.seven.edustat.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skybox.seven.edustat.model.ActiveCourseData
import com.skybox.seven.edustat.model.Site
import com.skybox.seven.edustat.repository.PrefRepository
import com.skybox.seven.edustat.repository.SiteRepository

class MainViewModel @ViewModelInject constructor(
    siteRepository: SiteRepository,
    prefRepository: PrefRepository
): ViewModel() {
    val siteInfo: LiveData<Site> = siteRepository.getSite(prefRepository.getUserID())
    val navigationData: MutableLiveData<ActiveCourseData> = MutableLiveData(ActiveCourseData())
}