package com.maksimnovikov.search.presentation

import com.maksimnovikov.common.domain.entity.FilmId

sealed class NavigationCommand() {
    class ToFilmDetail(val filmId: FilmId) : NavigationCommand()
}