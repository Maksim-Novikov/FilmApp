package com.maksimnovikov.search.presentation

import com.maksimnovikov.common.domain.entity.Film

sealed class NavigationCommand() {
    class ToFilmDetail(val film: Film) : NavigationCommand()
}