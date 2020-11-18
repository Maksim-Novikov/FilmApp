package com.maksimnovikov.favorites

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FavoritesInjector {

    @ContributesAndroidInjector
    fun contributesFavoritesFragment(): FavoritesFragment
}