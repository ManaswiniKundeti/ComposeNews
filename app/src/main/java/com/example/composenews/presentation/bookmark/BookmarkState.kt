package com.example.composenews.presentation.bookmark

import com.example.composenews.data.database.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)