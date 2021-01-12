package com.maksimnovikov.search.di

import com.maksimnovikov.search.data.SearchFilmRepositoryImpl
import com.maksimnovikov.search.data.network.SearchApi
import com.maksimnovikov.search.domain.SearchFilmRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
abstract class SearchFilmModule {

    @Binds
    abstract fun bindSearchFilmRepository(searchFilmRepository: SearchFilmRepositoryImpl): SearchFilmRepository


    companion object {

        @Provides
        fun provideHomeApi(retrofit: Retrofit): SearchApi = retrofit.create()
    }
}