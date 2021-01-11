package com.maksimnovikov.search

import com.maksimnovikov.common.domain.entity.FilmId

interface SearchRouter {

    fun showDetailInfo(filmId: FilmId)

    fun close()

}