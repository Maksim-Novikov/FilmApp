package com.maksimnovikov.common.domain.entity

import com.maksimnovikov.common.data.network.entity.GenreNw

data class Genre(val name: String)

fun GenreNw.toGenre(): Genre? {
    return Genre(genre ?: return null)
}