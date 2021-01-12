package com.maksimnovikov.search.data.network.entity


import com.maksimnovikov.common.data.network.entity.FilmNw
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    @Json(name = "keyword")
    val keyword: String?,
    @Json(name = "pagesCount")
    val pagesCount: Int?,
    @Json(name = "films")
    val films: List<FilmNw>?,
    @Json(name = "searchFilmsCountResult")
    val searchFilmsCountResult: Int?,
)