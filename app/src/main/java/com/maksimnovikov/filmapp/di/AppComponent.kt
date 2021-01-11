package com.maksimnovikov.filmapp.di

import android.content.Context
import com.maksimnovikov.favorites.FavoritesInjector
import com.maksimnovikov.filmapp.App
import com.maksimnovikov.filmapp.MainActivityInjector
import com.maksimnovikov.filmapp.di.modules.*
import com.maksimnovikov.home.di.HomeInjector
import com.maksimnovikov.home.di.HomeModule
import com.maksimnovikov.search.SearchInjector
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        NavigationModule::class,
        RouterModule::class,
        AndroidInjectionModule::class,
        MainActivityInjector::class,
        com.maksimnovikov.bottom_navigation.BottomInjector::class,
        HomeInjector::class,
        SearchInjector::class,
        FilmDetailFeatureModule::class,
//        FilmDetailInjector::class,
        FavoritesInjector::class,
        HomeModule::class,
    ]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Builder {

        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }
}