package com.example.composenews.presentation.navgraph

sealed class Route (
    val route: String
) {
    object OnboardingScreen: Route("onboardingScreen")
    object HomeScreen: Route("homeScreen")
    object SearchScreen: Route("searchScreen")
    object BookmarkScreen: Route("bookmarkScreen")
    object DetailsScreen: Route("detailsScreen")
    //subgraphs
    object AppStartNavigation: Route("appStartNavigation")
    object NewsNavigation: Route("newsNavigation")
    object NewsNavigatorScreen: Route("newsNavigatorScreen")
}