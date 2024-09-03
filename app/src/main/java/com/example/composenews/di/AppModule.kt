package com.example.composenews.di

import android.app.Application
import com.example.composenews.data.manager.LocalUserManagerImpl
import com.example.composenews.data.remote.NewsApi
import com.example.composenews.data.repository.NewsRepositoryImpl
import com.example.composenews.domain.manager.LocalUserManager
import com.example.composenews.domain.repository.NewsRepository
import com.example.composenews.domain.usecases.appEntry.AppEntryUsecases
import com.example.composenews.domain.usecases.appEntry.ReadAppEntry
import com.example.composenews.domain.usecases.appEntry.SaveAppEntry
import com.example.composenews.domain.usecases.news.GetNews
import com.example.composenews.domain.usecases.news.NewsUsecases
import com.example.composenews.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun providesNewsUsecases(
        newsRepository: NewsRepository
    ) : NewsUsecases {
        return NewsUsecases(
            getNews = GetNews(newsRepository)
        )
    }
}