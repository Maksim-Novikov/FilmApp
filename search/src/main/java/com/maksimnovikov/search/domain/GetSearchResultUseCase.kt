package com.maksimnovikov.search.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetSearchResultUseCase @Inject constructor(
    private val searchFilmRepository: SearchFilmRepository,
) {

    suspend operator fun invoke(keyword: String): SearchResult = withContext(Dispatchers.IO) {
        searchFilmRepository.searchByKeyword(keyword)
    }

}