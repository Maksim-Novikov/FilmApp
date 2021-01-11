package com.maksimnovikov.film_detail.di

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.maksimnovikov.common.domain.entity.FilmId
import com.maksimnovikov.film_detail.presentation.FilmDetailFragment
import javax.inject.Inject

class FilmDetailFeatureStarterImpl @Inject constructor() : FilmDetailFeatureStarter {

    override fun start(router: Router, filmId: FilmId) {
        router.navigateTo(Screens.filmDetail(filmId))
    }
}

object Screens {

    fun filmDetail(filmId: FilmId) = FragmentScreen { FilmDetailFragment.newInstance(filmId) }
}
