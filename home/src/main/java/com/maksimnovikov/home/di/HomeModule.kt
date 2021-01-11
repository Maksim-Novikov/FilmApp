package com.maksimnovikov.home.di

import com.maksimnovikov.home.data.TopFilmsRepositoryImpl
import com.maksimnovikov.home.data.network.HomeApi
import com.maksimnovikov.home.domain.TopFilmsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
abstract class HomeModule {

    @Binds
    abstract fun bindTopFilmsRepository(topFilmsRepositoryImpl: TopFilmsRepositoryImpl): TopFilmsRepository

    companion object {

        @Provides
        fun provideHomeApi(retrofit: Retrofit): HomeApi = retrofit.create()
    }
}