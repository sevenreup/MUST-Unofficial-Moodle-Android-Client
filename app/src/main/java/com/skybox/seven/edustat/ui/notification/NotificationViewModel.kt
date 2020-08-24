package com.skybox.seven.edustat.ui.notification

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.skybox.seven.edustat.dataSource.NotificationDataSourceFactory
import com.skybox.seven.edustat.model.Notification
import io.reactivex.rxjava3.disposables.CompositeDisposable

private const val TAG = "NotificationViewModel"
class NotificationViewModel @ViewModelInject constructor(
    private val compositeDisposable: CompositeDisposable,
    notificationFactory: NotificationDataSourceFactory
): ViewModel() {
    private val pageSize = 15
    val notifications: LiveData<PagedList<Notification>>

    init {
        val config  = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(pageSize)
            .build()
        notifications = LivePagedListBuilder<Int, Notification>(notificationFactory, config)
            .setBoundaryCallback(object: PagedList.BoundaryCallback<Notification>() {
                override fun onItemAtEndLoaded(itemAtEnd: Notification) {
                    super.onItemAtEndLoaded(itemAtEnd)
                    Log.e(TAG, "onItemAtEndLoaded: the end of list")
                }
            }).build()
    }
    fun reload() {
        notifications.value?.dataSource?.invalidate()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}