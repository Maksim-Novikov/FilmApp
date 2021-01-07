package com.maksimnovikov.filmapp.di.modules

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

// documentation here    https://kinopoiskapiunofficial.tech/documentation/api/#/films/get_api_v2_2_films_top

    @Provides
    @Singleton
    fun provideMoshiConverter(): Moshi = Moshi.Builder()
        .build()

    @Provides
    @Singleton
    fun provideOkHttp() =
        OkHttpClient.Builder().apply {}.build()

    @Provides
    @Singleton
    fun provideRetrofit(
        moshi: Moshi,
        client: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://kinopoiskapiunofficial.tech/")
        .client(client)
        .build()
}