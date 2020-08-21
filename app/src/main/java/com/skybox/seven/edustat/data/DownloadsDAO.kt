package com.skybox.seven.edustat.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.skybox.seven.edustat.model.DownloadFile
import io.reactivex.rxjava3.core.Completable

@Dao
interface DownloadsDAO {
    @Insert
    fun insert(downloadFile: DownloadFile): Completable

    @Insert
    fun insert(downloadFile: List<DownloadFile>): Completable

    @Query("Select * from downloads")
    fun getAllUnfinishedTask(): LiveData<List<DownloadFile>>

    @Query("Select * from downloads where taskId = :taskId")
    fun getTask(taskId: Int): LiveData<DownloadFile>

    @Update
    fun updateUsers(vararg task: DownloadFile): Completable
}