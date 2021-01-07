package com.maksimnovikov.film_detail.di

object FilmDetailComponentHolder {

    private var component: FilmDetailComponent? = null

    fun init(filmDetailFeatureDependencies: FilmDetailFeatureDependencies) {
        if (component == null) {
            synchronized(FilmDetailComponentHolder::class) {
                component = FilmDetailComponent.initAndGet(filmDetailFeatureDependencies)
            }
        }
    }

    internal fun getComponent(): FilmDetailComponent {
        return component!!
    }

    fun reset() {
        component = null
    }

    fun get(): FilmDetailFeatureApi {
        return component!!
    }
}