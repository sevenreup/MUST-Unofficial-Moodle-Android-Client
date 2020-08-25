package com.skybox.seven.edustat.ui.notification

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.airbnb.epoxy.addGlidePreloader
import com.airbnb.epoxy.glidePreloader
import com.airbnb.epoxy.preload.ViewData
import com.airbnb.epoxy.preload.ViewMetadata
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import com.skybox.seven.edustat.databinding.FragmentNotificationBinding
import com.skybox.seven.edustat.epoxy.controllers.NotificationController
import com.skybox.seven.edustat.epoxy.notification.ForumNotificationModel_
import com.skybox.seven.edustat.ui.main.MainViewModel
import com.skybox.seven.edustat.util.addTokenToUrl
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "NotificationFragment"
@AndroidEntryPoint
class NotificationFragment : Fragment() {
    private lateinit var binding: FragmentNotificationBinding
    private val viewModel: NotificationViewModel by viewModels()
    lateinit var controller: NotificationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        controller = NotificationController(viewModel.getToken()!!)
        viewModel.notifications.observe(this, Observer{
            controller.submitList(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        binding.recycler.setController(controller)
        binding.recycler.addGlidePreloader(
            Glide.with(this),
            preloader = glidePreloader { requestManager: RequestManager, model: ForumNotificationModel_,_ ->
                Log.e(TAG, "onCreateView: ${viewModel.getURL(model.user()?.profileimageurl!!)}")
                requestManager.loadImage(viewModel.getURL(model.user()?.profileimageurl!!), true)
            }
        )
        return binding.root
    }
}

fun RequestManager.loadImage(url: String, isPreloading: Boolean): RequestBuilder<Bitmap> {

    val options = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)
        .dontAnimate()
        .signature(ObjectKey(url.plus(if (isPreloading) "_preloading" else "_not_preloading")))

    return asBitmap()
        .apply(options)
        .load(url)
}