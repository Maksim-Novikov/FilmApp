package com.maksimnovikov.film_detail

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FilmDetailInjector {

    @ContributesAndroidInjector
    fun contributesFilmDetailFragment(): FilmDetailFragment
}