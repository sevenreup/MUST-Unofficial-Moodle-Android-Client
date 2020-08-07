package com.skybox.seven.edustat.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skybox.seven.edustat.api.MoodleService
import com.skybox.seven.edustat.api.response.AuthResponse
import com.skybox.seven.edustat.repository.PrefRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginViewModel @ViewModelInject constructor(
    private val moodleService: MoodleService,
    private val compositeDisposable: CompositeDisposable,
    private val prefRepository: PrefRepository
) : ViewModel() {
    var username: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()
    var loggedIn: MutableLiveData<Boolean> = MutableLiveData()

    fun login() {
        if (validate())
            compositeDisposable.add(
                moodleService.login(username.toString(), password.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { it }.subscribeWith(loginObserver())
            )

    }

    private fun validate(): Boolean {
        return true
    }

    private fun loginObserver(): DisposableSingleObserver<AuthResponse> {
        return object : DisposableSingleObserver<AuthResponse>() {
            override fun onSuccess(t: AuthResponse?) {
                if (t != null) {
                    prefRepository.saveToken(t)
                    loggedIn.value = true
                }
                // else server problems
            }

            override fun onError(e: Throwable?) {
                // Todo: show errors
                e?.printStackTrace()
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}