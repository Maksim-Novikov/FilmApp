package com.maksimnovikov.home.data.network

import com.maksimnovikov.home.data.network.entity.TopFilmsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {

    @GET("api/v2.2/films/top")
    suspend fun getTopFilms(
        @Query("type") type: String
    ): TopFilmsResponse
}

