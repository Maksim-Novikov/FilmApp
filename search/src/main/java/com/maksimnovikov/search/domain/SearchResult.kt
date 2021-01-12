package com.maksimnovikov.search.domain

import com.maksimnovikov.common.domain.entity.Film

data class SearchResult(
    val films: List<Film>,
    val keyword: String,
)