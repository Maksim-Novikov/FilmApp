package com.maksimnovikov.search

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface SearchInjector {

    @ContributesAndroidInjector
    fun contributesSearchFragment(): SearchFragment
}