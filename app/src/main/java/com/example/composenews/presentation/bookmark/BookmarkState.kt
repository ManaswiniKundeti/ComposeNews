package com.example.composenews.presentation.bookmark

import com.example.composenews.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)