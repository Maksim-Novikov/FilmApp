package com.maksimnovikov.filmapp.routing

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.maksimnovikov.bottom_navigation.BottomNavigationFragment
import com.maksimnovikov.common.domain.entity.FilmId
import com.maksimnovikov.favorites.FavoritesFragment
import com.maksimnovikov.film_detail.presentation.FilmDetailFragment
import com.maksimnovikov.home.ui.HomeFragment
import com.maksimnovikov.search.ui.SearchFragment

object Screens {

    fun bottom() = FragmentScreen { BottomNavigationFragment() }
    fun favorites() = FragmentScreen { FavoritesFragment() }
    fun search() = FragmentScreen { SearchFragment() }
    fun home() = FragmentScreen { HomeFragment() }
    fun filmDetail(filmId: FilmId) = FragmentScreen { FilmDetailFragment.newInstance(filmId) }
}