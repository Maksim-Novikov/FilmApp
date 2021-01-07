package com.maksimnovikov.film_detail.di

import com.maksimnovikov.common.PerFeature
import com.maksimnovikov.film_detail.data.FilmDetailApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class FilmDetailApiModule {

    @Provides
    @PerFeature
    fun provideFilmDetailApi(retrofit: Retrofit): FilmDetailApi = retrofit.create()

    @Provides
    fun bindFilmDetailFeatureStarter(filmDetailFeatureStarter: FilmDetailFeatureStarterImpl): FilmDetailFeatureStarter =
        filmDetailFeatureStarter
}