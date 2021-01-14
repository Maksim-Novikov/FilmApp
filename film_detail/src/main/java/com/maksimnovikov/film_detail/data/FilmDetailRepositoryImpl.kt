package com.maksimnovikov.film_detail.data

import com.maksimnovikov.common.domain.entity.FilmId
import com.maksimnovikov.film_detail.data.network.FilmDetailApi
import com.maksimnovikov.film_detail.domain.FilmDetailModel
import com.maksimnovikov.film_detail.domain.FilmDetailRepository
import com.maksimnovikov.film_detail.domain.toFilmDetailModel
import javax.inject.Inject

class FilmDetailRepositoryImpl @Inject constructor(
    private val filmDetailApi: FilmDetailApi,
) : FilmDetailRepository {

    override suspend fun getFilmDetail(filmId: FilmId): FilmDetailModel =
        filmDetailApi.getByFilmId(filmId.value).toFilmDetailModel()
}

