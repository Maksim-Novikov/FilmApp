package com.maksimnovikov.film_detail.data

import com.maksimnovikov.common.entity.FilmId
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmDetailApi {

    @GET("api/v2.1/films/{id}")
    suspend fun getByFilmId(@Path("id") filmId: FilmId): FilmDetailNw
}