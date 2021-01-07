package com.maksimnovikov.film_detail

import com.maksimnovikov.film_detail.presentation.FilmDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FilmDetailInjector {

    @ContributesAndroidInjector
    fun contributesFilmDetailFragment(): FilmDetailFragment
}