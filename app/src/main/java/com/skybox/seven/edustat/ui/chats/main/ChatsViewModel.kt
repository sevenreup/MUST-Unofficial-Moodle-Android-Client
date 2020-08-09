package com.skybox.seven.edustat.ui.chats.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skybox.seven.edustat.api.MoodleService
import com.skybox.seven.edustat.model.Conversation
import com.skybox.seven.edustat.repository.PrefRepository
import com.skybox.seven.edustat.util.Constants
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ChatsViewModel @ViewModelInject constructor(private val moodleService: MoodleService,
                                                  private val  prefRepository: PrefRepository,
                                                  private val compositeDisposable: CompositeDisposable): ViewModel() {
    val chatList:MutableLiveData<List<Conversation>> = MutableLiveData()

    fun getConversations() {
        compositeDisposable.add(
            moodleService.getAllChats(prefRepository.getUserID(), 0, 20, Constants.MESSAGE_CONVERSATION_TYPE_INDIVIDUAL,0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        if (it != null)
                            chatList.value = it.conversations
                        else
                            chatList.value = ArrayList()
                    },
                    {
                        it.printStackTrace()
                    })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}