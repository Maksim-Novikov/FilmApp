package com.maksimnovikov.bottom_navigation

import com.github.terrakok.cicerone.Screen

interface BottomRouter {

    fun getFavoritesTabScreen(): Screen

    fun getHomeTabScreen(): Screen

    fun getSearchTabScreen(): Screen
}