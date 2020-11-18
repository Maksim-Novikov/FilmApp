package com.maksimnovikov.filmapp.di.modules

import com.maksimnovikov.bottom_navigation.BottomRouter
import com.maksimnovikov.favorites.FavoritesRouter
import com.maksimnovikov.film_detail.FilmDetailRouter
import com.maksimnovikov.filmapp.routing.*
import com.maksimnovikov.home.HomeRouter
import com.maksimnovikov.search.SearchRouter
import dagger.Binds
import dagger.Module

@Module
interface RouterModule {

    @Binds
    fun bindBottomRouter(bottomRouterImpl: BottomRouterImpl): BottomRouter

    @Binds
    fun bindHomeRouter(homeRouterImpl: HomeRouterImpl): HomeRouter

    @Binds
    fun bindFavoritesRouter(favoritesRouterImpl: FavoritesRouterImpl): FavoritesRouter

    @Binds
    fun bindFilmDetailRouter(filmDetailRouterImpl: FilmDetailRouterImpl): FilmDetailRouter

    @Binds
    fun bindSearchRouter(searchRouterImpl: SearchRouterImpl): SearchRouter
}