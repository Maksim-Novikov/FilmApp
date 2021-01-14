package com.maksimnovikov.common.domain.entity

import android.os.Parcelable
import com.maksimnovikov.common.data.network.entity.CountryNw
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(val name: String) : Parcelable

fun CountryNw.toCountry(): Country? {
    return Country(country ?: return null)
}