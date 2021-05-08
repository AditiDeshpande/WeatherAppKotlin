package com.example.weatherappkotlin.Model


data class City (
    val weather:Weather,
    val main:Main,
    val wind:Wind,
    val name:String
        ){
}

data class Wind(
    val speed: Float
    ){
}

data class Main
    (val temp: Double,
    val humidity: Int,
    ){

}

data class Weather(
    val description: String
) {

}
