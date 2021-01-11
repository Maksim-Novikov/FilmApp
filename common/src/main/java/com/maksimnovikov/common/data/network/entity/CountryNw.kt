package com.maksimnovikov.common.data.network.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryNw(
    @Json(name = "country")
    val country: String?
)