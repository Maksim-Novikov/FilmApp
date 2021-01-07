package com.maksimnovikov.filmapp.di.modules

import com.maksimnovikov.film_detail.di.FilmDetailFeatureDependencies
import com.maksimnovikov.filmapp.di.FilmDetailFeatureDependenciesImpl
import dagger.Binds
import dagger.Module

@Module
abstract class FilmDetailFeatureModule {

    @Binds
    abstract fun bindFilmDetailFeatureDependencies(filmDetailFeatureDependencies: FilmDetailFeatureDependenciesImpl): FilmDetailFeatureDependencies

}