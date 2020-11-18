package com.maksimnovikov.filmapp

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityInjector {

    @ContributesAndroidInjector
    fun contributesMainActivity(): MainActivity
}