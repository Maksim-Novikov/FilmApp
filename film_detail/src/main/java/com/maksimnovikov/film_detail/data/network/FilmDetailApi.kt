package com.maksimnovikov.film_detail.data.network

import com.maksimnovikov.film_detail.data.network.entity.FilmDetailNw
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmDetailApi {

    @GET("api/v2.1/films/{id}?append_to_response=BUDGET,RATING,REVIEW,POSTERS")
    suspend fun getByFilmId(
        @Path("id") filmId: Int,
    ): FilmDetailNw
}