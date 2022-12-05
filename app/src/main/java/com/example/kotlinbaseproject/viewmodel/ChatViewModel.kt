package com.example.kotlinbaseproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinbaseproject.database.ChatDao
import com.example.kotlinbaseproject.model.Chat
import com.example.kotlinbaseproject.model.MessageType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ChatViewModel @Inject constructor(private val chatDao: ChatDao) : ViewModel() {

    fun addMessage(message: String, messageType: MessageType) {
        viewModelScope.launch(Dispatchers.IO) {
            val chat = Chat(message = message, messageType = messageType)
            chatDao.insertChaData(chat = chat)
        }
    }

    val getChatData = chatDao.getChatData()

}