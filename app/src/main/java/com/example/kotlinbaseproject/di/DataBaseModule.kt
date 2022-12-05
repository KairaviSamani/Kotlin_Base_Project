package com.example.kotlinbaseproject.di

import android.app.Application
import androidx.room.Room
import com.example.kotlinbaseproject.database.AppDatabase
import com.example.kotlinbaseproject.database.ChatDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideChatDB(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "AppDatabase.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideChatDao(appDataBase: AppDatabase): ChatDao {
        return appDataBase.chatDao()
    }

}
