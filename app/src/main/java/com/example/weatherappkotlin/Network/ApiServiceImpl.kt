package com.example.weatherappkotlin.Network

import com.example.weatherappkotlin.Model.City
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService){
    suspend fun getCityData(city:String , appId:String):City
    =apiService.getCityData(city , appId)

}