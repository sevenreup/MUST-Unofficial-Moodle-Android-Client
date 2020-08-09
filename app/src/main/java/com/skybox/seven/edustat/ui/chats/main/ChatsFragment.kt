package com.skybox.seven.edustat.ui.chats.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.airbnb.epoxy.addGlidePreloader
import com.airbnb.epoxy.glidePreloader
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.skybox.seven.edustat.MessagesDirections
import com.skybox.seven.edustat.databinding.FragmentChatsBinding
import com.skybox.seven.edustat.epoxy.controllers.ChatsController
import com.skybox.seven.edustat.epoxy.conversations.UserChatModel_
import com.skybox.seven.edustat.model.Member
import com.skybox.seven.edustat.util.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatsFragment : Fragment(), ChatsController.ChatsCallBack {
    private lateinit var binding: FragmentChatsBinding
    private val viewModel: ChatsViewModel by activityViewModels()
    private val controller: ChatsController = ChatsController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.chatList.observe(this, Observer {
            controller.setData(false, it)
        })
        viewModel.getConversations()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatsBinding.inflate(inflater, container, false)
        binding.root.setController(controller)
        binding.root.addGlidePreloader(Glide.with(requireContext()), preloader =
        glidePreloader { requestManager: RequestManager, epoxyModel: UserChatModel_, _ ->
            requestManager.loadImage(epoxyModel.image(), true)
        })
        return binding.root
    }

    override fun chatClicked(id: Int, member: Member, view: View) {
        val action = MessagesDirections.openChatSingle(member, id)
        findNavController().navigate(action)
    }

}