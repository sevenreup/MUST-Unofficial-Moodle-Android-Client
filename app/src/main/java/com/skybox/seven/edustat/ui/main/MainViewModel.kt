package com.skybox.seven.edustat.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.skybox.seven.edustat.model.Site
import com.skybox.seven.edustat.repository.PrefRepository
import com.skybox.seven.edustat.repository.SiteRepository

class MainViewModel @ViewModelInject constructor(
    siteRepository: SiteRepository,
    private val prefRepository: PrefRepository
): ViewModel() {
    var siteData: LiveData<Site> = siteRepository.getSite(prefRepository.getSite())

    fun getSiteData(): String {
        return prefRepository.getToken()!!
    }
}