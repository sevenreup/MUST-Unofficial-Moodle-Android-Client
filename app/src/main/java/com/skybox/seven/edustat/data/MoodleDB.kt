package com.skybox.seven.edustat.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.skybox.seven.edustat.model.Site

@Database(entities = [Site::class], version = 1)
abstract class MoodleDB : RoomDatabase(){
    abstract fun siteDAO(): SiteDAO
}