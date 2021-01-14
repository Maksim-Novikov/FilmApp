package com.maksimnovikov.common.domain.entity

import android.os.Parcelable
import com.maksimnovikov.common.data.network.entity.GenreNw
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genre(val name: String) : Parcelable

fun GenreNw.toGenre(): Genre? {
    return Genre(genre ?: return null)
}