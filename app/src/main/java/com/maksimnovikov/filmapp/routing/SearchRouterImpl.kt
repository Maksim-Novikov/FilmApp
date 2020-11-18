package com.maksimnovikov.filmapp.routing

import com.maksimnovikov.bottom_navigation.LocalCiceroneHolder
import com.maksimnovikov.common.entity.FilmId
import com.maksimnovikov.search.SearchRouter
import javax.inject.Inject

class SearchRouterImpl @Inject constructor(
    private val localCiceroneHolder: LocalCiceroneHolder
) : SearchRouter {

    override fun showDetailInfo(filmId: FilmId) {
        localCiceroneHolder.getCurrentRouter().navigateTo(Screens.filmDetail(filmId))
    }

    override fun close() {
        localCiceroneHolder.getCurrentRouter().exit()
    }
}