package com.example.kotlinbaseproject.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinbaseproject.model.Chat

@Database(entities = [Chat::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun chatDao(): ChatDao
}