package com.skybox.seven.edustat.epoxy.generic

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelView


@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_MATCH_HEIGHT)
class CarouselList(context: Context) : Carousel(context) {
    override fun createLayoutManager(): LayoutManager {
        return LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    }
}