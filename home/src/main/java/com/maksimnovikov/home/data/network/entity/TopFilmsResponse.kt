package com.maksimnovikov.home.data.network.entity


import com.maksimnovikov.common.data.network.entity.FilmNw
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopFilmsResponse(
    @Json(name = "pagesCount")
    val pagesCount: Int?,
    @Json(name = "films")
    val films: List<FilmNw?>?
)