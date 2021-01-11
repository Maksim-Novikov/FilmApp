package com.maksimnovikov.film_detail.di

import com.maksimnovikov.film_detail.FilmDetailRouter
import retrofit2.Retrofit

interface FilmDetailFeatureDependencies {

    val retrofit: Retrofit
    val filmDetailRouter: FilmDetailRouter
}