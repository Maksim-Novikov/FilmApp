package com.maksimnovikov.film_detail.domain

import com.maksimnovikov.common.domain.entity.FilmId

interface FilmDetailRepository {

    suspend fun getFilmDetail(filmId: FilmId): FilmDetailModel
}