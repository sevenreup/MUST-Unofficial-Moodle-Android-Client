package com.skybox.seven.edustat.ui.login

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skybox.seven.edustat.api.MoodleService
import com.skybox.seven.edustat.repository.PrefRepository
import com.skybox.seven.edustat.repository.SiteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

private const val TAG = "LoginViewModel"
class LoginViewModel @ViewModelInject constructor(
    private val moodleService: MoodleService,
    private val compositeDisposable: CompositeDisposable,
    private val prefRepository: PrefRepository,
    private val siteRepository: SiteRepository
) : ViewModel() {
    var username: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()
    var loggedIn: MutableLiveData<Boolean> = MutableLiveData()

    fun login() {
        if (validate())
            compositeDisposable.add(
                moodleService.login(username.value!!, password.value!!)
                    .flatMap {
                        prefRepository.saveToken(it).andThen(Single.just(it))
                    }.flatMap {
                        moodleService.getSite()
                    }.flatMap {
                        siteRepository.insertSite(it).andThen(Single.just(it))
                    }.flatMap {
                        prefRepository.saveSiteUserID(it.userId).andThen(Single.just(it))
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        if (it != null) {
                            loggedIn.value = true
                        } else {
                            Log.e(TAG, "login: site is null")
                        }
                    }, {
                        // todo: handle
                        Log.e(TAG, "login: ", it)
                    })
            )

    }

    private fun validate(): Boolean {
        return true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}