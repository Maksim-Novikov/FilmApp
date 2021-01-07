package com.maksimnovikov.film_detail.domain

import com.maksimnovikov.common.data.noRequiredField
import com.maksimnovikov.common.entity.FilmId
import com.maksimnovikov.film_detail.data.Data
import com.maksimnovikov.film_detail.data.FilmDetailNw

data class FilmDetailModel(val id: FilmId) {

}

fun FilmDetailNw.toFilmDetailModel(): FilmDetailModel {
    return FilmDetailModel(
        id = FilmId(value = data?.filmId ?: throw noRequiredField(Data::filmId))
    )
}