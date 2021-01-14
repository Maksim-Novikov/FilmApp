package com.maksimnovikov.home

import com.maksimnovikov.common.domain.entity.Film

interface HomeRouter {

    fun showDetailInfo(film: Film)
    fun close()
}