package com.skybox.seven.edustat.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.skybox.seven.edustat.model.DownloadFile
import com.skybox.seven.edustat.model.Site

@Database(entities = [Site::class, DownloadFile::class], version = 1)
abstract class MoodleDB : RoomDatabase(){
    abstract fun siteDAO(): SiteDAO
    abstract fun downloadsDAO(): DownloadsDAO
}