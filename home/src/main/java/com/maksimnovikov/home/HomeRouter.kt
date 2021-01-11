package com.maksimnovikov.home

import com.maksimnovikov.common.domain.entity.FilmId

interface HomeRouter {

    fun showDetailInfo(filmId: FilmId)
    fun close()
}