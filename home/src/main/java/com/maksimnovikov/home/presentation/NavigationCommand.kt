package com.maksimnovikov.home.presentation

import com.maksimnovikov.common.domain.entity.Film

sealed class NavigationCommand {
    class ToFilmDetail(internal val film: Film) : NavigationCommand()
    object Back : NavigationCommand()
}