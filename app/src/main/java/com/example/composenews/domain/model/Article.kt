package com.example.composenews.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source, // have obj. We can only save primitive types in DB. So we need a way to convert this obj to primitive types. So use type converter in Room
    val title: String,
    @PrimaryKey val url: String,
    val urlToImage: String
)