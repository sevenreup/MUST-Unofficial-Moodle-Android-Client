package com.skybox.seven.edustat.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.skybox.seven.edustat.model.DownloadFile
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface DownloadsDAO {
    @Insert
    fun insert(downloadFile: DownloadFile): Completable

    @Insert
    fun insert(downloadFile: Collection<DownloadFile>): Completable

    @Query("Select * from downloads where downloaded = :downloaded")
    fun getAllUnfinishedTask(downloaded: Boolean): LiveData<List<DownloadFile>>

    @Query("Select * from downloads Where sectionId = :sectionID")
    fun getAllFinishedSectionFiles(sectionID: Int): LiveData<List<DownloadFile>>

    @Query("Select * from downloads where moduleId = :moduleId")
    fun getTask(moduleId: Int): Single<DownloadFile>

    @Update
    fun updateUsers(vararg task: DownloadFile): Completable

    @Query("Update downloads Set filePath = :path, downloaded = :downloaded  Where moduleId = :moduleId")
    fun downloadComplete(moduleId: Int, path: String, downloaded: Boolean): Completable
}