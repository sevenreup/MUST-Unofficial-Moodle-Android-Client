package com.skybox.seven.edustat.ui.chats.chat

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skybox.seven.edustat.api.MoodleService
import com.skybox.seven.edustat.model.Member
import com.skybox.seven.edustat.model.Message
import com.skybox.seven.edustat.repository.PrefRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ChatSingleViewModel @ViewModelInject constructor(private val moodleService: MoodleService,
                                                       private val prefRepository: PrefRepository,
                                                       private val compositeDisposable: CompositeDisposable): ViewModel() {
    val messages:MutableLiveData<List<Message>> = MutableLiveData()
    val member:MutableLiveData<Member> = MutableLiveData()

    fun getMessages(id: Int) {
        compositeDisposable.add(
            moodleService.getAllMessagesInChat(prefRepository.getUserID(), id, 0, 20, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it != null) {
                        messages.value = it.messages
                    }
                }, {it.printStackTrace()})
        )
    }

    fun getUserID() = prefRepository.getUserID()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}