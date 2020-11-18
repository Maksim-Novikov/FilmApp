package com.maksimnovikov.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface HomeInjector {

    @ContributesAndroidInjector
    fun contributesHomeFragment(): HomeFragment
}