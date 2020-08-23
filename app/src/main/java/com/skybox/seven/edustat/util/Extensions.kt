package com.skybox.seven.edustat.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.core.content.res.use
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

/**
 * Retrieve a color from the current [android.content.res.Resources.Theme].
 */
@ColorInt
@SuppressLint("Recycle")
fun Context.themeColor(
    @AttrRes themeAttrId: Int
): Int {
    return obtainStyledAttributes(
        intArrayOf(themeAttrId)
    ).use {
        it.getColor(0, Color.MAGENTA)
    }
}