package com.maksimnovikov.film_detail.presentation

import com.maksimnovikov.film_detail.domain.FilmDetailModel

sealed class FilmDetailScreenState {
    class Error(val throwable: Throwable) : FilmDetailScreenState()
    object Loading : FilmDetailScreenState()
    class Content(val content: FilmDetailModel) : FilmDetailScreenState()
}