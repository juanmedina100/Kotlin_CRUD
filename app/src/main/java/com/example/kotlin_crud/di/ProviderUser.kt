package com.example.kotlin_crud.di

import android.content.Context
import androidx.room.Room
import com.example.kotlin_crud.db.DatabaseUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProviderUser {

    @Provides
    @Singleton
    fun ProviderRoom(@ApplicationContext context: Context)=
        Room.databaseBuilder(context,DatabaseUser::class.java,"database").build()

    @Provides
    @Singleton
    fun ProvideDao(db:DatabaseUser)=db.dao()
}