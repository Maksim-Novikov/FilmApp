package com.maksimnovikov.film_detail.di

import com.maksimnovikov.common.di.PerFeature
import com.maksimnovikov.film_detail.data.FilmDetailRepositoryImpl
import com.maksimnovikov.film_detail.data.network.FilmDetailApi
import com.maksimnovikov.film_detail.domain.FilmDetailRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class FilmDetailApiModule {

    @Provides
    @PerFeature
    fun provideFilmDetailRepository(filmDetailRepositoryImpl: FilmDetailRepositoryImpl): FilmDetailRepository =
        filmDetailRepositoryImpl

    @Provides
    @PerFeature
    fun provideFilmDetailApi(retrofit: Retrofit): FilmDetailApi = retrofit.create()

    @Provides
    fun bindFilmDetailFeatureStarter(filmDetailFeatureStarter: FilmDetailFeatureStarterImpl): FilmDetailFeatureStarter =
        filmDetailFeatureStarter
}