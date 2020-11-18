package com.maksimnovikov.filmapp.routing

import com.maksimnovikov.bottom_navigation.LocalCiceroneHolder
import com.maksimnovikov.common.entity.FilmId
import com.maksimnovikov.home.HomeRouter
import javax.inject.Inject

class HomeRouterImpl @Inject constructor(
    private val localCiceroneHolder: LocalCiceroneHolder
) : HomeRouter {

    override fun showDetailInfo(filmId: FilmId) {
        localCiceroneHolder.getCurrentRouter().navigateTo(Screens.filmDetail(filmId))
    }

    override fun close() {
        localCiceroneHolder.getCurrentRouter().exit()
    }
}