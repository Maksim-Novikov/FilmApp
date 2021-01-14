package com.maksimnovikov.film_detail.presentation

sealed class NavigationCommand {
    object Back : NavigationCommand()
}