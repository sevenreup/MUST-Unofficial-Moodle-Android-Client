package com.skybox.seven.edustat.ui.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skybox.seven.edustat.adapter.ConversationsAdapter
import com.skybox.seven.edustat.databinding.FragmentConversationBinding

class ConversationsFragment : Fragment() {
    private lateinit var binding: FragmentConversationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConversationBinding.inflate(inflater, container, false)
        binding.viewPager.adapter = ConversationsAdapter(childFragmentManager, lifecycle)
        return binding.root
    }

}