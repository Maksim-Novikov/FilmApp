package com.maksimnovikov.film_detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.common.ui.extensions.launchWithErrorHandler
import com.maksimnovikov.film_detail.domain.GetFilmDetailUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class FilmDetailViewModel(
    private val film: Film,
    private val getFilmDetailUseCase: GetFilmDetailUseCase,
) : ViewModel() {

    private val _screenState: MutableStateFlow<FilmDetailScreenState> =
        MutableStateFlow(FilmDetailScreenState.Loading)

    val screenState: Flow<FilmDetailScreenState> = _screenState
    private val _navigationCommand: MutableSharedFlow<NavigationCommand> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val navigationCommand: Flow<NavigationCommand> = _navigationCommand

    init {
        loadData()
    }

    fun onRetry() {
        _screenState.value = FilmDetailScreenState.Loading
        loadData()
    }

    private fun loadData() {
        viewModelScope.launchWithErrorHandler(
            block = {
                val result = FilmDetailScreenState.Content(getFilmDetailUseCase(film.filmId))
                _screenState.value = result
            },
            onError = {
                _screenState.value = FilmDetailScreenState.Error(it)
            }
        )
    }

    fun onBackPressed() {
        _navigationCommand.tryEmit(NavigationCommand.Back)
    }
}

