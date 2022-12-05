package com.example.kotlinbaseproject.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kotlinbaseproject.model.Chat

@Dao
interface ChatDao {

    @Insert
    suspend fun insertChaData(chat: Chat)

    @Query("SELECT * FROM Chat")
    fun getChatData(): LiveData<List<Chat>?>

    @Delete
    suspend fun deleteChatData(chat: Chat)

    @Update
    suspend fun updateChatData(chat: Chat)
}