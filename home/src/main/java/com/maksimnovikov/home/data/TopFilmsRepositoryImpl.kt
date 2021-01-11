package com.maksimnovikov.home.data

import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.common.domain.entity.toFilm
import com.maksimnovikov.home.data.network.HomeApi
import com.maksimnovikov.home.data.network.entity.TopFilmsResponse
import com.maksimnovikov.home.domain.TopFilmsRepository
import com.maksimnovikov.home.domain.TopType
import javax.inject.Inject

class TopFilmsRepositoryImpl @Inject constructor(private val homeApi: HomeApi) :
    TopFilmsRepository {

    override suspend fun getTopFilms(topType: TopType): List<Film> =
        homeApi.getTopFilms(topType.serverName).toFilms()
}

private fun TopFilmsResponse.toFilms(): List<Film> {
    return films?.mapNotNull { it?.toFilm() } ?: emptyList()
}

