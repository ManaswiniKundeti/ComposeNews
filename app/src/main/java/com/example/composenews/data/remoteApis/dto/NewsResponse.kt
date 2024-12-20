package com.example.composenews.data.remoteApis.dto

import com.example.composenews.data.database.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)