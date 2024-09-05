package com.example.composenews.domain.usecases.news

import com.example.composenews.data.local.NewsDao
import com.example.composenews.domain.model.Article
import com.example.composenews.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article) {
        return newsRepository.upsertArticle(article)
    }
}