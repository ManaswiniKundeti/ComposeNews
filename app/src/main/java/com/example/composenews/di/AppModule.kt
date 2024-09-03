package com.example.composenews.di

import android.app.Application
import com.example.composenews.data.manager.LocalUserManagerImpl
import com.example.composenews.domain.manager.LocalUserManager
import com.example.composenews.domain.usecases.appEntry.AppEntryUsecases
import com.example.composenews.domain.usecases.appEntry.ReadAppEntry
import com.example.composenews.domain.usecases.appEntry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUsecases(
        localUserManager: LocalUserManager
    ) =  AppEntryUsecases (
        readAppEntry =  ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}