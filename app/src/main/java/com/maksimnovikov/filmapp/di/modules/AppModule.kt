package com.maksimnovikov.filmapp.di.modules

import com.maksimnovikov.film_detail.di.FilmDetailComponentHolder
import com.maksimnovikov.film_detail.di.FilmDetailFeatureApi
import com.maksimnovikov.film_detail.di.FilmDetailFeatureDependencies
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideFeatureFilmDetail(dependencies: FilmDetailFeatureDependencies): FilmDetailFeatureApi {
        FilmDetailComponentHolder.init(dependencies)
        return FilmDetailComponentHolder.get()
    }
}