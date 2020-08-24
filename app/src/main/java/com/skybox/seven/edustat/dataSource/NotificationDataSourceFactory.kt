package com.skybox.seven.edustat.dataSource

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.skybox.seven.edustat.api.MoodleService
import com.skybox.seven.edustat.model.Notification
import com.skybox.seven.edustat.repository.PrefRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class NotificationDataSourceFactory @Inject constructor(private val moodleService: MoodleService,
                                                        private val compositeDisposable: CompositeDisposable,
                                                        private val prefRepository: PrefRepository
): DataSource.Factory<Int, Notification>() {

    override fun create(): DataSource<Int, Notification> {
        return NotificationDataSource(moodleService, compositeDisposable, prefRepository.getUserID())
    }
}

class NotificationDataSource (private val moodleService: MoodleService,
                              private val compositeDisposable: CompositeDisposable,
                              private val userID: Int
): PageKeyedDataSource<Int, Notification>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Notification>
    ) {
        compositeDisposable.add(
            moodleService.getAllNotifications(userID, 1,0, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    callback.onResult(it.notifications, null, params.requestedLoadSize)
                }, {
                    // todo: handle exception
                })
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Notification>) {
        moodleService.getAllNotifications(userID, 1, params.key, params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .subscribe({
                callback.onResult(it.notifications, (params.key + params.requestedLoadSize))
            }, {
                // todo: handle exception
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Notification>) {
    }
}