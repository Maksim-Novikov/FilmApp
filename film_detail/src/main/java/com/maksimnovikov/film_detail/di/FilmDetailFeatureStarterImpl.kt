package com.maksimnovikov.film_detail.di

import com.github.terrakok.cicerone.Router
import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.film_detail.Screens
import javax.inject.Inject

class FilmDetailFeatureStarterImpl @Inject constructor() : FilmDetailFeatureStarter {

    override fun start(router: Router, film: Film) {
        router.navigateTo(Screens.filmDetail(film))
    }
}

