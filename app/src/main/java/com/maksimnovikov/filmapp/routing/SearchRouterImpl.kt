package com.maksimnovikov.filmapp.routing

import com.maksimnovikov.bottom_navigation.LocalCiceroneHolder
import com.maksimnovikov.common.entity.FilmId
import com.maksimnovikov.film_detail.di.FilmDetailFeatureApi
import com.maksimnovikov.search.SearchRouter
import javax.inject.Inject
import javax.inject.Provider

class SearchRouterImpl @Inject constructor(
    private val localCiceroneHolder: LocalCiceroneHolder,
    private val filmDetailFeatureApi: Provider<FilmDetailFeatureApi>
) : SearchRouter {

    override fun showDetailInfo(filmId: FilmId) {
        filmDetailFeatureApi.get().starter().start(localCiceroneHolder.getCurrentRouter(), filmId)
    }

    override fun close() {
        localCiceroneHolder.getCurrentRouter().exit()
    }
}