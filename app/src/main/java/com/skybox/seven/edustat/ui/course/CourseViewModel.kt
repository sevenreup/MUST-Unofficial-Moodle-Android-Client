package com.skybox.seven.edustat.ui.course

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skybox.seven.edustat.api.MoodleService
import com.skybox.seven.edustat.model.Section
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CourseViewModel @ViewModelInject constructor(private val moodleService: MoodleService, private val compositeDisposable: CompositeDisposable): ViewModel() {
    val courseSections: MutableLiveData<List<Section>> = MutableLiveData()

    fun getCourseContent(id: Int) {
        compositeDisposable.add(
            moodleService.getCourseContent(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    courseSections.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}