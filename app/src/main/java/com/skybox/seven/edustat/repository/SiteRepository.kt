package com.skybox.seven.edustat.repository

import androidx.lifecycle.LiveData
import com.skybox.seven.edustat.data.SiteDAO
import com.skybox.seven.edustat.model.Site
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SiteRepository @Inject constructor(private val siteDAO: SiteDAO) {

    fun insertSite(site: Site): Completable = siteDAO.insert(site)

    fun getSite(site: Int): LiveData<Site> {
        return siteDAO.getSite(site)
    }
}