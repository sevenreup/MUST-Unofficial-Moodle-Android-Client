package com.skybox.seven.edustat.util

import android.content.Context
import java.io.File

fun getParentFile(context: Context): File = context.externalCacheDir ?: context.cacheDir
