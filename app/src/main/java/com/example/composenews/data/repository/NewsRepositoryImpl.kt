package com.example.composenews.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.composenews.data.remote.NewsApi
import com.example.composenews.data.remote.NewsPagingSource
import com.example.composenews.domain.model.Article
import com.example.composenews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
): NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
       return Pager(
           config = PagingConfig(pageSize = 10), //# of articles to be fetched
           pagingSourceFactory = {
               NewsPagingSource(
                   newsApi = newsApi,
                   sources = sources.joinToString(separator = ",")
               )
           }
       ).flow
    }
}