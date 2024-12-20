package com.example.composenews.domain.usecases.news

import com.example.composenews.data.database.model.Article
import com.example.composenews.domain.repository.NewsRepository

class GetArticle (
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url: String): Article?{
        return newsRepository.getArticle(url)
    }

}