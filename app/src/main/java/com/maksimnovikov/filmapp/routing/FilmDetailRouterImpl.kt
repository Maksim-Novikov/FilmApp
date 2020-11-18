package com.maksimnovikov.filmapp.routing

import com.maksimnovikov.bottom_navigation.LocalCiceroneHolder
import com.maksimnovikov.common.entity.FilmId
import com.maksimnovikov.film_detail.FilmDetailRouter
import javax.inject.Inject

class FilmDetailRouterImpl @Inject constructor(
    private val localCiceroneHolder: LocalCiceroneHolder
) : FilmDetailRouter {

    override fun openStaff(filmId: FilmId) {

    }

    override fun openReviews(filmId: FilmId) {
    }

    override fun close() {
        localCiceroneHolder.getCurrentRouter().exit()
    }
}