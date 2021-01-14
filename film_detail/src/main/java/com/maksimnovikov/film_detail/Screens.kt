package com.maksimnovikov.film_detail

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.film_detail.ui.FilmDetailFragment

object Screens {

    fun filmDetail(film: Film) = FragmentScreen { FilmDetailFragment.newInstance(film) }
}