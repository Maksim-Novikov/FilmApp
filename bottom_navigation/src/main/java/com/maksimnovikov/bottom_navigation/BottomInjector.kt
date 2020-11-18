package com.maksimnovikov.bottom_navigation

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BottomInjector {

    @ContributesAndroidInjector
    fun contributesBottomFragment(): BottomNavigationFragment

    @ContributesAndroidInjector
    fun contributesTabContainerFragment(): TabContainerFragment
}