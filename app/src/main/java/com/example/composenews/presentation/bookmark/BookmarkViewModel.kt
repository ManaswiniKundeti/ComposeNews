package com.example.composenews.presentation.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenews.domain.usecases.news.NewsUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val newsUsecases: NewsUsecases
): ViewModel() {

    private val _bookmarkState = mutableStateOf(BookmarkState())
    val bookmarkState: State<BookmarkState> = _bookmarkState

    init {
        getArticles()
    }

    private fun getArticles(){
        newsUsecases.getArticles().onEach {
            _bookmarkState.value = _bookmarkState.value.copy(articles = it)
        }.launchIn(viewModelScope)
    }
}