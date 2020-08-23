package com.skybox.seven.edustat.util

import androidx.databinding.BindingAdapter
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator

@BindingAdapter("app:currentProgress")
fun setCurrentProgress(view: CircularProgressIndicator, progress: Double) {
    view.setCurrentProgress(progress)
}