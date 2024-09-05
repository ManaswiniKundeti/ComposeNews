package com.example.composenews.domain.usecases.news

import com.example.composenews.data.local.NewsDao
import com.example.composenews.domain.model.Article

class GetArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}