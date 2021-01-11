package com.maksimnovikov.common.domain.entity

import com.maksimnovikov.common.data.network.entity.FilmNw

data class Film(
    val filmId: FilmId,
    val name: String,
    val year: String,
    val genres: List<Genre>,
    val rating: String,
    val posterUrlPreview: String?,
) {

    val genre: String? get() = genres.firstOrNull()?.name
}

fun FilmNw.toFilm(): Film? {
    return Film(
        filmId = FilmId(filmId ?: return null),
        name = nameRu?.takeIf { it.isNotBlank() } ?: nameEn?.takeIf { it.isNotBlank() }
        ?: return null,
        year = year ?: return null,
        genres = genres?.mapNotNull { it.toGenre() } ?: emptyList(),
        rating = rating ?: return null,
        posterUrlPreview = posterUrlPreview
    )
}

