package com.example.kotlinbaseproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "Chat")
data class Chat(
    @PrimaryKey(autoGenerate = true)
    var chatId: Int = 0,
    var message: String? = null,
    var messageType: MessageType? = null
) {
    override fun toString(): String {
        return "Chat(chatId=$chatId, message=$message, messageType=$messageType)"
    }
}

enum class MessageType {
    SENDER,
    RECEIVER
}

