package com.maksimnovikov.favorites

import com.maksimnovikov.common.domain.entity.FilmId

interface FavoritesRouter {

    fun showDetailInfo(filmId: FilmId)

    fun close()
}