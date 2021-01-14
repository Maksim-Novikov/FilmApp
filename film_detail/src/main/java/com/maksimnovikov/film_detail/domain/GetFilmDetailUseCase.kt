package com.maksimnovikov.film_detail.domain

import com.maksimnovikov.common.domain.entity.FilmId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetFilmDetailUseCase @Inject constructor(
    private val filmDetailRepository: FilmDetailRepository,
) {

    suspend operator fun invoke(filmId: FilmId): FilmDetailModel = withContext(Dispatchers.IO) {
        filmDetailRepository.getFilmDetail(filmId)
    }
}