package com.maksimnovikov.film_detail

import com.maksimnovikov.common.domain.entity.FilmId

interface FilmDetailRouter {

    fun openStaff(filmId: FilmId)

    fun openReviews(filmId: FilmId)

    fun close()
}