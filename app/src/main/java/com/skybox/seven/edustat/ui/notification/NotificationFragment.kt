package com.skybox.seven.edustat.ui.notification

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.skybox.seven.edustat.databinding.FragmentNotificationBinding
import com.skybox.seven.edustat.epoxy.controllers.NotificationController
import com.skybox.seven.edustat.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "NotificationFragment"
@AndroidEntryPoint
class NotificationFragment : Fragment() {
    private lateinit var binding: FragmentNotificationBinding
    private val viewModel: NotificationViewModel by viewModels()
    val controller = NotificationController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        return binding.root
    }
}