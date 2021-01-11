package com.maksimnovikov.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.common.ui.extensions.launchWithErrorHandler
import com.maksimnovikov.home.domain.GetHomeContentUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getHomeContentUseCase: GetHomeContentUseCase,
) : ViewModel() {


    private val _screenState: MutableStateFlow<HomeScreenState> =
        MutableStateFlow(HomeScreenState.Loading)

    val screenState: Flow<HomeScreenState> = _screenState
    private val _navigationCommand: MutableSharedFlow<NavigationCommand> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val navigationCommand: Flow<NavigationCommand> = _navigationCommand

    init {
        viewModelScope.launchWithErrorHandler(block = {
            val content = HomeScreenState.Content(getHomeContentUseCase())
            _screenState.value = content
        }, onError = {
            _screenState.value = HomeScreenState.Error
        })
    }

    fun onFilmClick(film: Film) {
        _navigationCommand.tryEmit(NavigationCommand.ToFilmDetail(film.filmId))
    }

    fun onBackPressed() {
        _navigationCommand.tryEmit(NavigationCommand.Back)
    }
}

