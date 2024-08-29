package com.example.composenews.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.composenews.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Stay Updated with the Latest News",
        description = "Get real-time updates on global and local news tailored to your interests. Never miss a beat with personalized news feeds and alerts.",
        image = R.drawable.onboarding1a
    ),
    Page(
        title = "Discover Content That Matters",
        description = "Our intelligent algorithm curates news articles, blogs, and videos that match your preferences. Dive into topics you care about most.",
        image = R.drawable.onboarding2a
    ),
    Page(
        title = "Navigate with Ease",
        description = "Enjoy a smooth and user-friendly interface designed for effortless browsing. Find what you’re looking for with just a tap.",
        image = R.drawable.onboarding3a
    )
)
