package com.maksimnovikov.search.data

import com.maksimnovikov.common.domain.entity.toFilm
import com.maksimnovikov.search.data.network.SearchApi
import com.maksimnovikov.search.data.network.entity.SearchResponse
import com.maksimnovikov.search.domain.SearchFilmRepository
import com.maksimnovikov.search.domain.SearchResult
import javax.inject.Inject

class SearchFilmRepositoryImpl @Inject constructor(private val searchApi: SearchApi) :
    SearchFilmRepository {

    override suspend fun searchByKeyword(keyword: String): SearchResult =
        searchApi.searchByKeyWord(keyword).toSearchResult()
}

private fun SearchResponse.toSearchResult(): SearchResult {
    return SearchResult(
        films = films?.mapNotNull { it.toFilm() } ?: emptyList(),
        keyword = keyword ?: ""
    )

}

