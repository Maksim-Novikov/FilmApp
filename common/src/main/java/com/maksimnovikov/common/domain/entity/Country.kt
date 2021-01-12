package com.maksimnovikov.common.domain.entity

import com.maksimnovikov.common.data.network.entity.CountryNw

data class Country(val name: String)

fun CountryNw.toCountry(): Country? {
    return Country(country ?: return null)
}