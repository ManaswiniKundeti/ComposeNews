package com.example.composenews.domain.usecases.news

import androidx.paging.PagingData
import com.example.composenews.domain.model.Article
import com.example.composenews.domain.repository.NewsRepository

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): kotlinx.coroutines.flow.Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}