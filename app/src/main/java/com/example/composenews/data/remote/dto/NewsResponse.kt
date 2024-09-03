package com.example.composenews.data.remote.dto

import com.example.composenews.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)