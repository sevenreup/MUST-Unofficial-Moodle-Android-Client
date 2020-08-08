package com.skybox.seven.edustat.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.skybox.seven.edustat.ui.chats.pages.ChatsFragment
import com.skybox.seven.edustat.ui.chats.pages.GroupChatsFragment

class ConversationsAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ChatsFragment()
            1 -> return GroupChatsFragment()
        }
        return ChatsFragment()
    }
}