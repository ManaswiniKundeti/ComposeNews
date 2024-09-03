package com.example.composenews.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenews.domain.usecases.appEntry.AppEntryUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val appEntryUsecases: AppEntryUsecases
): ViewModel() {

    fun onEvent(event: OnboardingEvent) {
        when(event) {
            is OnboardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUsecases.saveAppEntry()
        }
    }
}