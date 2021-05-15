package com.example.weatherappkotlin.DI

import com.example.weatherappkotlin.Network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
/*
Meaning of following @InstallIn annotation is I can use this module
anywhere in the application
 */
@InstallIn(ApplicationComponent::class)
class AppModule {
    @Provides
    fun providesBaseUrl(): String =
        "http://api.openweathermap.org/data/2.5/"

    @Provides
    @Singleton
    fun providesRetrofitBuilder(baseurl:String): Retrofit
    = Retrofit.Builder()
        .baseUrl(baseurl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun providesApiService(retrofit: Retrofit):ApiService
    = retrofit.create(ApiService::class.java)




}