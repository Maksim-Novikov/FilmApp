package com.maksimnovikov.common.data.network.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenreNw(
    @Json(name = "genre")
    val genre: String?
)