package com.maksimnovikov.home.presentation

import com.maksimnovikov.home.domain.HomeContent

sealed class HomeScreenState {
    object Error : HomeScreenState()
    object Loading : HomeScreenState()
    class Content(val homeContent: HomeContent) : HomeScreenState()
}