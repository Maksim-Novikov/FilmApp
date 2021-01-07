package com.maksimnovikov.filmapp.di

import com.maksimnovikov.film_detail.di.FilmDetailFeatureDependencies
import retrofit2.Retrofit
import javax.inject.Inject

class FilmDetailFeatureDependenciesImpl @Inject constructor(
    override val retrofit: Retrofit
) : FilmDetailFeatureDependencies

