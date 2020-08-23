package com.skybox.seven.edustat.util

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey

fun RequestManager.loadImage(
    url: String,
    isPreloading: Boolean
): RequestBuilder<Bitmap> {
    val options =  RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)
        .signature(ObjectKey(url.plus(if (isPreloading) "_preloading" else "_not_preloading")))
    return asBitmap().apply(options).load(url)
}

fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}