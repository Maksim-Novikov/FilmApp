package com.maksimnovikov.search.di

import com.maksimnovikov.search.ui.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface SearchInjector {

    @ContributesAndroidInjector
    fun contributesSearchFragment(): SearchFragment
}