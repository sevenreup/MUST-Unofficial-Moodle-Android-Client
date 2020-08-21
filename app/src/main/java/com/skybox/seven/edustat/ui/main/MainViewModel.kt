package com.skybox.seven.edustat.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skybox.seven.edustat.model.ActiveCourseData

class MainViewModel: ViewModel() {
    val navigationData: MutableLiveData<ActiveCourseData> = MutableLiveData(ActiveCourseData())
}