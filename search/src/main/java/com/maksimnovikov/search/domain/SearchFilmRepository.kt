package com.maksimnovikov.search.domain

interface SearchFilmRepository {

    suspend fun searchByKeyword(keyword: String): SearchResult
}