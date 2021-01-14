package com.maksimnovikov.search

import com.maksimnovikov.common.domain.entity.Film

interface SearchRouter {

    fun showDetailInfo(film: Film)

    fun close()

}