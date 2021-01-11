package com.maksimnovikov.common.data.network.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmNw(
    @Json(name = "filmId")
    val filmId: Int?,
    @Json(name = "nameRu")
    val nameRu: String?,
    @Json(name = "nameEn")
    val nameEn: String?,
    @Json(name = "year")
    val year: String?,
    @Json(name = "filmLength")
    val filmLength: String?,
    @Json(name = "countries")
    val countries: List<CountryNw>?,
    @Json(name = "genres")
    val genres: List<GenreNw>?,
    @Json(name = "rating")
    val rating: String?,
    @Json(name = "ratingVoteCount")
    val ratingVoteCount: Int?,
    @Json(name = "posterUrl")
    val posterUrl: String?,
    @Json(name = "posterUrlPreview")
    val posterUrlPreview: String?,
    @Json(name = "ratingChange")
    val ratingChange: String?
)