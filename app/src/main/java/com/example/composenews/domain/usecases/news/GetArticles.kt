package com.example.composenews.domain.usecases.news

import com.example.composenews.data.local.NewsDao
import com.example.composenews.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

}