package com.maksimnovikov.film_detail.domain

import com.maksimnovikov.common.domain.entity.FilmId
import com.maksimnovikov.film_detail.data.FilmDetailApi
import javax.inject.Inject

class GetFilmDetailUseCase @Inject constructor(
    private val filmDetailApi: FilmDetailApi
) {

    suspend operator fun invoke(filmId: FilmId): FilmDetailModel {
        return filmDetailApi.getByFilmId(filmId).toFilmDetailModel()
    }
}