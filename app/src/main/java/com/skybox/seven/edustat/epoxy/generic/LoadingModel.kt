package com.skybox.seven.edustat.epoxy.generic

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder

@EpoxyModelClass(layout = R.layout.model_loading)
abstract class LoadingModel: EpoxyModelWithHolder<LoadingHolder>() {
    override fun getDefaultLayout(): Int = R.layout.model_loading

    override fun createNewHolder(): LoadingHolder = LoadingHolder()

}

class LoadingHolder : BaseEpoxyHolder() {

}