package com.maksimnovikov.filmapp.di

import android.content.Context
import com.maksimnovikov.favorites.FavoritesInjector
import com.maksimnovikov.film_detail.FilmDetailInjector
import com.maksimnovikov.filmapp.App
import com.maksimnovikov.filmapp.MainActivityInjector
import com.maksimnovikov.filmapp.di.modules.NavigationModule
import com.maksimnovikov.filmapp.di.modules.RouterModule
import com.maksimnovikov.search.SearchInjector
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [
        NavigationModule::class,
        RouterModule::class,
        AndroidInjectionModule::class,
        MainActivityInjector::class,
        com.maksimnovikov.bottom_navigation.BottomInjector::class,
        com.maksimnovikov.home.HomeInjector::class,
        SearchInjector::class,
        FilmDetailInjector::class,
        FavoritesInjector::class,
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