package com.maksimnovikov.home.ui

import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.common.ui.saveStateRecycler.RecyclerState
import com.maksimnovikov.common.ui.saveStateRecycler.RecyclerStateImpl

sealed class HomeScreenViewItem {
    class Header(val name: String) : HomeScreenViewItem()
    class Slider(val films: List<Film>) : HomeScreenViewItem(), RecyclerState by RecyclerStateImpl()
}