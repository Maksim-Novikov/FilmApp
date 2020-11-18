package com.maksimnovikov.filmapp.routing

import com.github.terrakok.cicerone.Screen
import com.maksimnovikov.bottom_navigation.BottomRouter
import javax.inject.Inject

class BottomRouterImpl @Inject constructor() : BottomRouter {

    override fun getFavoritesTabScreen(): Screen = Screens.favorites()
    override fun getHomeTabScreen(): Screen = Screens.home()
    override fun getSearchTabScreen(): Screen = Screens.search()
}

