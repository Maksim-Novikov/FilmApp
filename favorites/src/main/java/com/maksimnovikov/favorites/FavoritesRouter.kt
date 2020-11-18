package com.maksimnovikov.favorites

import com.maksimnovikov.common.entity.FilmId

interface FavoritesRouter {

    fun showDetailInfo(filmId: FilmId)

    fun close()
}