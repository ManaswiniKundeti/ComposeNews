package com.example.composenews

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenews.domain.usecases.AppEntryUsecases
import com.example.composenews.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val appEntryUsecases: AppEntryUsecases
): ViewModel() {

    // get value from datastore preferences to determine if we need to route
    // to the OB screen next or to the NewsNavigator screen
    // If AppEntry value is true -> NewsNavigatorScreen (into the app)
    // if AppEntry value is false -> OnboardingScreen (as OB is not yet complete)


    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUsecases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            if (shouldStartFromHomeScreen) {
                startDestination = Route.NewsNavigation.route
            } else {
                startDestination = Route.AppStartNavigation.route
            }
            delay(3600)
            splashCondition = false

        }.launchIn(viewModelScope)
    }
}