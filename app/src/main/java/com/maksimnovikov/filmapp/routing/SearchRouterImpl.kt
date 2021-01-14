package com.maksimnovikov.filmapp.routing

import com.maksimnovikov.bottom_navigation.LocalCiceroneHolder
import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.film_detail.di.FilmDetailFeatureApi
import com.maksimnovikov.search.SearchRouter
import javax.inject.Inject
import javax.inject.Provider

class SearchRouterImpl @Inject constructor(
    private val localCiceroneHolder: LocalCiceroneHolder,
    private val filmDetailFeatureApi: Provider<FilmDetailFeatureApi>
) : SearchRouter {

    override fun showDetailInfo(film: Film) {
        filmDetailFeatureApi.get().starter().start(localCiceroneHolder.getCurrentRouter(), film)
    }

    override fun close() {
        localCiceroneHolder.getCurrentRouter().exit()
    }
}