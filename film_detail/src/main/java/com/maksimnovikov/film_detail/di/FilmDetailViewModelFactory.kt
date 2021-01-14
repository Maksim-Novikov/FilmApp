package com.maksimnovikov.film_detail.di

import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.film_detail.domain.GetFilmDetailUseCase
import com.maksimnovikov.film_detail.presentation.FilmDetailViewModel
import javax.inject.Inject

class FilmDetailViewModelFactory @Inject constructor(private val getFilmDetailUseCase: GetFilmDetailUseCase) {

    fun create(film: Film) = FilmDetailViewModel(
        film = film,
        getFilmDetailUseCase = getFilmDetailUseCase
    )
}