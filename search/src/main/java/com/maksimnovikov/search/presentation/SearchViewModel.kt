package com.maksimnovikov.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.common.ui.extensions.launchWithErrorHandler
import com.maksimnovikov.search.domain.GetSearchResultUseCase
import com.maksimnovikov.search.domain.SearchResult
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getSearchResultUseCase: GetSearchResultUseCase,
) : ViewModel() {

    private val cache = mutableMapOf<String, SearchResult>()
    private var searchJob: Job? = null

    private val _screenState = MutableStateFlow<SearchScreenState>(SearchScreenState.Initial)
    val screenState: Flow<SearchScreenState> = _screenState

    private val _navigationCommand: MutableSharedFlow<NavigationCommand> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val navigationCommand: Flow<NavigationCommand> = _navigationCommand

    fun onEditChanged(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launchWithErrorHandler(block = {
            delay(300)
            val cached = cache[query]
            if (cached != null) {
                _screenState.value = SearchScreenState.Result(cached)
                return@launchWithErrorHandler
            }
            val result = getSearchResultUseCase(query)
            _screenState.value = SearchScreenState.Result(result)
            cache[query] = result
        }, onError = {
            _screenState.value = SearchScreenState.Error
        })
    }

    fun onClearEditClick() {
        _screenState.value = SearchScreenState.Initial
    }

    fun onFilmClicked(film: Film) {
        _navigationCommand.tryEmit(NavigationCommand.ToFilmDetail(film.filmId))
    }
}
