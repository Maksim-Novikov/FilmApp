package com.maksimnovikov.filmapp.routing

import com.maksimnovikov.bottom_navigation.LocalCiceroneHolder
import com.maksimnovikov.common.entity.FilmId
import com.maksimnovikov.favorites.FavoritesRouter
import javax.inject.Inject

class FavoritesRouterImpl @Inject constructor(
    private val localCiceroneHolder: LocalCiceroneHolder
) : FavoritesRouter {


    override fun showDetailInfo(filmId: FilmId) {

    }

    override fun close() {
        localCiceroneHolder.getCurrentRouter().exit()
    }
}