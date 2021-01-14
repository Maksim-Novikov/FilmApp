package com.maksimnovikov.film_detail.domain

import com.maksimnovikov.common.data.noRequiredField
import com.maksimnovikov.common.domain.entity.FilmId
import com.maksimnovikov.film_detail.data.network.entity.Data
import com.maksimnovikov.film_detail.data.network.entity.FilmDetailNw
import com.maksimnovikov.film_detail.data.network.entity.SeasonsItem

data class FilmDetailModel(

    val filmId: FilmId,

    val year: String,
    val nameRu: String,
    val nameEn: String? = null,
    val description: String,
    val filmLength: String,
    val genres: List<String>,

    val type: String? = null,
    val facts: List<String?>,

    val seasons: List<SeasonsItem?>? = null,
    val countries: List<String>,
    val webUrl: String? = null,

    val distributors: String? = null,
    val distributorRelease: String? = null,

    val ratingMpaa: String? = null,
    val ratingAgeLimits: Int? = null,

    val posterUrl: String,
    val posterUrlPreview: String,

    val slogan: String? = null,

    val premiereDigital: String? = null,
    val premiereBluRay: String? = null,
    val premiereDvd: String? = null,
    val premiereWorld: String? = null,
    val premiereRu: String? = null,
    val premiereWorldCountry: String? = null,
)

fun FilmDetailNw.toFilmDetailModel(): FilmDetailModel {
    return FilmDetailModel(
        filmId = FilmId(value = data?.filmId ?: throw noRequiredField(Data::filmId)),
        premiereDigital = data.premiereDigital,
        premiereBluRay = data.premiereBluRay,
        year = data.year ?: throw noRequiredField(Data::year),
        premiereDvd = data.premiereDvd,
        filmLength = data.filmLength ?: throw noRequiredField(Data::filmLength),
        description = data.description ?: throw noRequiredField(Data::description),
        type = data.type,
        facts = data.facts ?: emptyList(),
        nameRu = data.nameRu ?: throw noRequiredField(Data::nameRu),
        posterUrl = data.posterUrl ?: throw noRequiredField(Data::posterUrl),
        genres = data.genres?.mapNotNull { it?.genre } ?: emptyList(),
        ratingMpaa = data.ratingMpaa,
        ratingAgeLimits = data.ratingAgeLimits,
        seasons = data.seasons,
        distributors = data.distributors,
        nameEn = data.nameEn,
        countries = data.countries?.mapNotNull { it?.country } ?: emptyList(),
        premiereWorld = data.premiereWorld,
        webUrl = data.webUrl,
        premiereRu = data.premiereRu,
        distributorRelease = data.distributorRelease,
        premiereWorldCountry = data.premiereWorldCountry,
        posterUrlPreview = data.posterUrlPreview ?: throw noRequiredField(Data::posterUrlPreview),
        slogan = data.slogan,
    )
}