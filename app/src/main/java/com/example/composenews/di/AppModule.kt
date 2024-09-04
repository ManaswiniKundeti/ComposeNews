package com.example.composenews.di

import android.app.Application
import androidx.room.Room
import com.example.composenews.data.local.NewsDao
import com.example.composenews.data.local.NewsDatabase
import com.example.composenews.data.local.NewsTypeConverter
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
import com.example.composenews.domain.usecases.news.SearchNews
import com.example.composenews.util.Constants.BASE_URL
import com.example.composenews.util.Constants.NEWS_DATABASE_NAME
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
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao = newsDatabase.newsDao
}