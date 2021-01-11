package com.maksimnovikov.film_detail.di

import com.github.terrakok.cicerone.Router
import com.maksimnovikov.common.domain.entity.FilmId

interface FilmDetailFeatureStarter {

    fun start(router: Router, filmId: FilmId)
}