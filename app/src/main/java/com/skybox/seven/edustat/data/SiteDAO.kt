package com.skybox.seven.edustat.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.skybox.seven.edustat.model.Site
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface SiteDAO {
    @Insert
    fun insert(site: Site):Completable

    @Query("Select * from site where userId = :user")
    fun getSite(user: Int): LiveData<Site>
}