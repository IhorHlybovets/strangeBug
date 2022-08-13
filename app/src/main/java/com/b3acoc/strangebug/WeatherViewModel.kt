package com.b3acoc.strangebug

import android.view.View
import androidx.annotation.NonNull
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel(): ViewModel() {
//class WeatherViewModel(): BaseObservable() {

    var CLEAR_DAY = "00"

//    @Bindable
    var mutableWeatherData: MutableLiveData<String> = MutableLiveData()
    val weatherDataToObserve: MutableLiveData<String> get() = mutableWeatherData

    fun setCurrentWeatherData (currentWeatherData: String) {
        mutableWeatherData.postValue(currentWeatherData)
//        notifyPropertyChanged(BR.mutableWeatherData)
    }

}

