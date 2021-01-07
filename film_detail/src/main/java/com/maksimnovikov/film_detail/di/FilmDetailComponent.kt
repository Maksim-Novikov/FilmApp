package com.maksimnovikov.film_detail.di

import com.maksimnovikov.common.PerFeature
import com.maksimnovikov.film_detail.presentation.FilmDetailFragment
import dagger.Component

@Component(
    dependencies = [FilmDetailFeatureDependencies::class],
    modules = [FilmDetailApiModule::class]
)
@PerFeature
internal abstract class FilmDetailComponent : FilmDetailFeatureApi {

    internal abstract fun inject(filmDetailFragment: FilmDetailFragment)

    companion object {

        fun initAndGet(filmDetailFeatureDependencies: FilmDetailFeatureDependencies): FilmDetailComponent {
            return DaggerFilmDetailComponent.builder()
                .filmDetailFeatureDependencies(filmDetailFeatureDependencies)
                .build()
        }
    }
}

