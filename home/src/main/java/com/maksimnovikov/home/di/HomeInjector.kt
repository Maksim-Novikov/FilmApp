package com.maksimnovikov.home.di

import com.maksimnovikov.home.ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface HomeInjector {

    @ContributesAndroidInjector
    fun contributesHomeFragment(): HomeFragment
}