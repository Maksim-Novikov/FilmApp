package com.maksimnovikov.film_detail.data

import com.squareup.moshi.Json

data class FilmDetailNw(

    @Json(name = "images")
    val images: Images? = null,

    @Json(name = "data")
    val data: Data? = null,

    @Json(name = "review")
    val review: Review? = null,

    @Json(name = "rating")
    val rating: Rating? = null,

    @Json(name = "externalId")
    val externalId: ExternalId? = null,

    @Json(name = "budget")
    val budget: Budget? = null
)

data class EpisodesItem(

    @Json(name = "nameRu")
    val nameRu: String? = null,

    @Json(name = "releaseDate")
    val releaseDate: String? = null,

    @Json(name = "seasonNumber")
    val seasonNumber: Int? = null,

    @Json(name = "nameEn")
    val nameEn: String? = null,

    @Json(name = "synopsis")
    val synopsis: String? = null,

    @Json(name = "episodeNumber")
    val episodeNumber: Int? = null
)

data class GenresItem(

    @Json(name = "name")
    val name: String? = null
)

data class Rating(

    @Json(name = "ratingRfCriticsVoteCount")
    val ratingRfCriticsVoteCount: Int? = null,

    @Json(name = "ratingImdb")
    val ratingImdb: Double? = null,

    @Json(name = "ratingVoteCount")
    val ratingVoteCount: Int? = null,

    @Json(name = "rating")
    val rating: Double? = null,

    @Json(name = "ratingRfCritics")
    val ratingRfCritics: String? = null,

    @Json(name = "ratingImdbVoteCount")
    val ratingImdbVoteCount: Int? = null,

    @Json(name = "ratingAwait")
    val ratingAwait: String? = null,

    @Json(name = "ratingAwaitCount")
    val ratingAwaitCount: Int? = null,

    @Json(name = "ratingFilmCritics")
    val ratingFilmCritics: String? = null,

    @Json(name = "ratingFilmCriticsVoteCount")
    val ratingFilmCriticsVoteCount: Int? = null
)

data class BackdropsItem(

    @Json(name = "width")
    val width: Int? = null,

    @Json(name = "language")
    val language: String? = null,

    @Json(name = "url")
    val url: String? = null,

    @Json(name = "height")
    val height: Int? = null
)

data class Budget(

    @Json(name = "marketing")
    val marketing: Int? = null,

    @Json(name = "grossRu")
    val grossRu: Int? = null,

    @Json(name = "grossUsa")
    val grossUsa: Int? = null,

    @Json(name = "grossWorld")
    val grossWorld: Int? = null,

    @Json(name = "budget")
    val budget: String? = null
)

data class Images(

    @Json(name = "backdrops")
    val backdrops: List<BackdropsItem?>? = null,

    @Json(name = "posters")
    val posters: List<PostersItem?>? = null
)

data class PostersItem(

    @Json(name = "width")
    val width: Int? = null,

    @Json(name = "language")
    val language: String? = null,

    @Json(name = "url")
    val url: String? = null,

    @Json(name = "height")
    val height: Int? = null
)

data class ExternalId(

    @Json(name = "imdbId")
    val imdbId: String? = null
)

data class SeasonsItem(

    @Json(name = "number")
    val number: Int? = null,

    @Json(name = "episodes")
    val episodes: List<EpisodesItem?>? = null
)

data class Data(

    @Json(name = "premiereDigital")
    val premiereDigital: String? = null,

    @Json(name = "premiereBluRay")
    val premiereBluRay: String? = null,

    @Json(name = "year")
    val year: String? = null,

    @Json(name = "premiereDvd")
    val premiereDvd: String? = null,

    @Json(name = "filmLength")
    val filmLength: String? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "facts")
    val facts: List<String?>? = null,

    @Json(name = "nameRu")
    val nameRu: String? = null,

    @Json(name = "posterUrl")
    val posterUrl: String? = null,

    @Json(name = "genres")
    val genres: List<GenresItem?>? = null,

    @Json(name = "ratingMpaa")
    val ratingMpaa: String? = null,

    @Json(name = "ratingAgeLimits")
    val ratingAgeLimits: Int? = null,

    @Json(name = "seasons")
    val seasons: List<SeasonsItem?>? = null,

    @Json(name = "distributors")
    val distributors: String? = null,

    @Json(name = "nameEn")
    val nameEn: String? = null,

    @Json(name = "countries")
    val countries: List<CountriesItem?>? = null,

    @Json(name = "premiereWorld")
    val premiereWorld: String? = null,

    @Json(name = "webUrl")
    val webUrl: String? = null,

    @Json(name = "premiereRu")
    val premiereRu: String? = null,

    @Json(name = "distributorRelease")
    val distributorRelease: String? = null,

    @Json(name = "filmId")
    val filmId: Int? = null,

    @Json(name = "premiereWorldCountry")
    val premiereWorldCountry: String? = null,

    @Json(name = "posterUrlPreview")
    val posterUrlPreview: String? = null,

    @Json(name = "slogan")
    val slogan: String? = null
)

data class CountriesItem(

    @Json(name = "name")
    val name: String? = null
)

data class Review(

    @Json(name = "ratingGoodReviewVoteCount")
    val ratingGoodReviewVoteCount: Int? = null,

    @Json(name = "reviewsCount")
    val reviewsCount: Int? = null,

    @Json(name = "ratingGoodReview")
    val ratingGoodReview: String? = null
)
