package com.example.composenews.domain.usecases.news

import androidx.paging.PagingData
import com.example.composenews.domain.model.Article
import com.example.composenews.domain.repository.NewsRepository

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): kotlinx.coroutines.flow.Flow<PagingData<Article>> {
        return newsRepository.searchNews(sources = sources, searchQuery = searchQuery)
    }
}