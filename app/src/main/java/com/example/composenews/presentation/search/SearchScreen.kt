package com.example.composenews.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.composenews.presentation.common.ArticlesList
import com.example.composenews.presentation.common.SearchBar
import com.example.composenews.presentation.navgraph.Route
import com.example.composenews.presentation.onboarding.Dimens.mediumPadding1

@Composable
fun SearchScreen(
    state: SearchState,
    event:(SearchEvent) -> Unit,
    navigate:(String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(
                top = mediumPadding1,
                start = mediumPadding1,
                end = mediumPadding1
            )
            .statusBarsPadding()
    ) {
        SearchBar(
            text = state.searchQuery, 
            readOnly = false, 
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it))},
            onSearch = { event(SearchEvent.SearchNews)}
        )
        Spacer(modifier = Modifier.height(mediumPadding1))

        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(articles = (articles), onClick = { navigate(Route.DetailsScreen.route)} )
        }
    }
}