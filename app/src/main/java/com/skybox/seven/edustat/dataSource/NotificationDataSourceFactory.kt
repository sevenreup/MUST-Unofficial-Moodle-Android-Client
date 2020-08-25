package com.skybox.seven.edustat.dataSource

import android.util.Log
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.skybox.seven.edustat.api.MoodleService
import com.skybox.seven.edustat.model.Notification
import com.skybox.seven.edustat.repository.PrefRepository
import com.skybox.seven.edustat.util.createMapOfNotifications
import com.skybox.seven.edustat.util.getUserIdsFromNotification
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

private const val TAG = "NotificationDataSourceF"
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
        var notifications: List<Notification> = ArrayList()
        compositeDisposable.add(
            moodleService.getAllNotifications(userID, 1,0, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .flatMap {
                    notifications = it.notifications
                    moodleService.getUserProfileByField("id", getUserIdsFromNotification(it.notifications))
                }
                .subscribe({
                    val map = createMapOfNotifications(notifications)
                    Log.e(TAG, "Map size: ${map.size()}, Users: ${it.size}")
                    it.forEach { user ->
                        map.get(user.id.toString()).forEach { not ->
                            Log.e(TAG, "setting: ${user.fullname}")
                            not.user = user
                        }
                    }
                    callback.onResult(ArrayList(map.values()), null, params.requestedLoadSize)
                }, {
                    // todo: handle exception
                })
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Notification>) {
        var notifications: List<Notification> = ArrayList()
        moodleService.getAllNotifications(userID, 1, params.key, params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .flatMap {
                notifications = it.notifications
                moodleService.getUserProfileByField("id", getUserIdsFromNotification(it.notifications))
            }
            .subscribe({
                val map = createMapOfNotifications(notifications)
                it.forEach { user ->
                    map.get(user.id.toString()).forEach { not ->
                        not.user = user
                    }
                }
                callback.onResult(ArrayList(map.values()), (params.key + params.requestedLoadSize))
            }, {
                // todo: handle exception
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Notification>) {
    }
}
