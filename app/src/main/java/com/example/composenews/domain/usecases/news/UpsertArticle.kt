package com.example.composenews.domain.usecases.news

import com.example.composenews.data.local.NewsDao
import com.example.composenews.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article) {
        return newsDao.upsert(article)
    }
}