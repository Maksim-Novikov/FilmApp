package com.maksimnovikov.filmapp.routing

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.maksimnovikov.bottom_navigation.BottomNavigationFragment
import com.maksimnovikov.favorites.FavoritesFragment
import com.maksimnovikov.home.ui.HomeFragment
import com.maksimnovikov.search.ui.SearchFragment

object Screens {

    fun bottom() = FragmentScreen { BottomNavigationFragment() }
    fun favorites() = FragmentScreen { FavoritesFragment() }
    fun search() = FragmentScreen { SearchFragment() }
    fun home() = FragmentScreen { HomeFragment() }
}