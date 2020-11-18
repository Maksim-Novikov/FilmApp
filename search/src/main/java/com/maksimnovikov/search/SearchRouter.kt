package com.maksimnovikov.search

import com.maksimnovikov.common.entity.FilmId

interface SearchRouter {

    fun showDetailInfo(filmId: FilmId)

    fun close()

}