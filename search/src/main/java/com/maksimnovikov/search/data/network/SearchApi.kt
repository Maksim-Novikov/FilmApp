package com.maksimnovikov.search.data.network

import com.maksimnovikov.search.data.network.entity.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("api/v2.1/films/search-by-keyword")
    suspend fun searchByKeyWord(
        @Query("keyword") keyword: String,
        @Query("page") page: Int = 1,
    ): SearchResponse
}