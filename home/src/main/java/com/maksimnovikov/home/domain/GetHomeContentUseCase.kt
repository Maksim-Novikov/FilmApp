package com.maksimnovikov.home.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetHomeContentUseCase @Inject constructor(
    private val topFilmsRepository: TopFilmsRepository
) {

    suspend operator fun invoke(): HomeContent = withContext(Dispatchers.IO) {
        val top100 = async { topFilmsRepository.getTopFilms(TopType.TOP_100_POPULAR_FILMS) }
        val top250 = async { topFilmsRepository.getTopFilms(TopType.TOP_250_BEST_FILMS) }
        val topAwait = async { topFilmsRepository.getTopFilms(TopType.TOP_AWAIT_FILMS) }
        HomeContent(
            top250BestFilms = top250.await(),
            top100PopularFilms = top100.await(),
            topAwaitFilms = topAwait.await()
        )
    }
}

