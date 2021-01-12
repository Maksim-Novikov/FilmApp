package com.maksimnovikov.common.domain.entity

import com.maksimnovikov.common.data.network.entity.FilmNw

data class Film(
    val filmId: FilmId,
    val nameRu: String,
    val nameEn: String?,
    val year: String,
    private val genres: List<Genre>,
    private val countries: List<Country>,
    val rating: String,
    val posterUrlPreview: String?,
) {

    val firstGenre: String? get() = genres.firstOrNull()?.name
    val country: String get() = countries.joinToString(separator = ", ", transform = { it.name })
    val genresString: String get() = genres.joinToString(separator = ", ", transform = { it.name })

}

fun FilmNw.toFilm(): Film? {
    return Film(
        filmId = FilmId(filmId ?: return null),
        nameRu = nameRu?.takeIf { it.isNotBlank() } ?: nameEn?.takeIf { it.isNotBlank() }
        ?: return null,
        nameEn = nameEn,
        year = year ?: return null,
        genres = genres?.mapNotNull { it.toGenre() } ?: emptyList(),
        countries = countries?.mapNotNull { it.toCountry() } ?: emptyList(),
        rating = rating ?: return null,
        posterUrlPreview = posterUrlPreview
    )
}

