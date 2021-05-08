package com.example.weatherappkotlin.Network

import com.example.weatherappkotlin.Model.City
import retrofit2.http.GET
import retrofit2.http.Query

/*
http://api.openweathermap.org/data/2.5/weather?q=Pune&appid={APIKey}
End point of the URL above URL is not full here just copied
part of it there will be city name after q and also API key will
be there
q is query and app id is API key
 */
interface ApiService {
    @GET("weather")
    suspend fun getCityData(
        @Query("q")q:String,
        @Query("appid")appId:String
    ):City
}