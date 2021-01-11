package com.maksimnovikov.home.domain

import com.maksimnovikov.common.domain.entity.Film

class HomeContent(
    val top250BestFilms: List<Film>,
    val top100PopularFilms: List<Film>,
    val topAwaitFilms: List<Film>
)