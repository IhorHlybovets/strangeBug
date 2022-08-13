package com.b3acoc.strangebug


import android.util.Log
import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner


class LgWeatherAnimationClass() :
    DefaultLifecycleObserver, WeatherChangeInterface {

    private var globalNumVariable = ""


    override fun doSmth (weatherCondition: String, viewsArray: Array<View>) {
        Log.e("doSmth", "$weatherCondition doSmth")
        globalNumVariable = weatherCondition
    }


    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)

        Log.e("onstart", "onstart")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.e("onStop", "onStop")

    }

}

interface WeatherChangeInterface {
    fun doSmth(weatherCondition: String, viewsArray: Array<View>)
}