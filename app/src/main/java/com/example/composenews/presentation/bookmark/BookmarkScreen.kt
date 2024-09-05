package com.example.composenews.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.composenews.R
import com.example.composenews.domain.model.Article
import com.example.composenews.presentation.common.ArticleCard
import com.example.composenews.presentation.common.ArticlesList
import com.example.composenews.presentation.navgraph.Route
import com.example.composenews.presentation.onboarding.Dimens.mediumPadding1

@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigateToDetails:(Article) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = mediumPadding1, start = mediumPadding1, end = mediumPadding1)
    ) {

        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(
                id = R.color.text_title
            )
        )

        Spacer(modifier = Modifier.height(mediumPadding1))

        ArticlesList(
            articles = state.articles,
            onClick = navigateToDetails
        )
    }
}