package com.maksimnovikov.home.domain

import com.maksimnovikov.common.domain.entity.Film

interface TopFilmsRepository {

    suspend fun getTopFilms(topType: TopType): List<Film>
}