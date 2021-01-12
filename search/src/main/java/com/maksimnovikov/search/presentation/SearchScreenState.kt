package com.maksimnovikov.search.presentation

import com.maksimnovikov.search.domain.SearchResult

sealed class SearchScreenState() {
    object Initial : SearchScreenState()
    class Result(val content: SearchResult) : SearchScreenState()
    object Error : SearchScreenState()
}