package com.skybox.seven.edustat.ui.chats.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.skybox.seven.edustat.databinding.FragmentChatSingleBinding
import com.skybox.seven.edustat.epoxy.controllers.ChatController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatSingleFragment : Fragment() {
    private lateinit var binding: FragmentChatSingleBinding
    private val viewModel: ChatSingleViewModel by viewModels()
    private lateinit var args: ChatSingleFragmentArgs
    private lateinit var controller: ChatController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args = ChatSingleFragmentArgs.fromBundle(requireArguments())
        controller = ChatController(viewModel.getUserID())
        viewModel.messages.observe(this, Observer {
            controller.setData(false, it)
        })
        viewModel.getMessages(args.convID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatSingleBinding.inflate(inflater, container, false)
        binding.recycler.setController(controller)
        binding.recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)
        return binding.root
    }

}