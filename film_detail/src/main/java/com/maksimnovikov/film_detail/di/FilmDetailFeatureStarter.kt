package com.maksimnovikov.film_detail.di

import com.github.terrakok.cicerone.Router
import com.maksimnovikov.common.domain.entity.Film

interface FilmDetailFeatureStarter {

    fun start(router: Router, film: Film)
}