package com.example.weatherappkotlin.ViewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappkotlin.Model.City
import com.example.weatherappkotlin.Repository.WeatherRepository
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel
@ViewModelInject
constructor(private val weatherRepository: WeatherRepository)
    : ViewModel() {
    /*
    ConflatedBroadcastChannel it sends current data only to the
    Repository , the one which is typed just now
     */
    val searchCity = ConflatedBroadcastChannel<String>()

    val getData: MutableLiveData<City> = MutableLiveData()
    /*
    Foll. method fetches recently typed city name in search view from UI
    */
    fun getSearchData(city: String){
        searchCity.offer(city)
    }

    fun getCityData() = viewModelScope.launch {
        searchCity.asFlow() //Channel is converted into flow as Repository needs flow for this method
            .flatMapLatest { city->
                weatherRepository.getCityData(city)
                /*
                Does the work of sending latest data
                 */
            }.catch { e->
                Log.d("main","getCityData")
            }.collect { city->
                getData.value = city
            }


    }



}