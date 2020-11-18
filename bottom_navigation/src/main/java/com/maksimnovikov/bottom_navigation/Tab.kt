package com.maksimnovikov.bottom_navigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class Tab(val name: String) : Parcelable {
    @Parcelize
    class Favorites : Tab("favorites")

    @Parcelize
    class Home : Tab("home")

    @Parcelize
    class Search : Tab("search")
}