package com.b3acoc.strangebug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.b3acoc.strangebug.databinding.FragmentAnimatorBinding


class AnimatorFragment : Fragment() {
    private var fragmentBinding: FragmentAnimatorBinding? = null
    private val binding get() = fragmentBinding!!

//    private lateinit var fragViewModel: WeatherViewModel
    private val fragViewModel: WeatherViewModel by activityViewModels()
    private lateinit var lgWeatherAnimation: LgWeatherAnimationClass

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_animator, container, false)

//        fragViewModel = WeatherViewModel()
        binding.weatherViewModel = fragViewModel
        binding.lifecycleOwner = viewLifecycleOwner


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lgWeatherAnimation = LgWeatherAnimationClass()
        lifecycle.addObserver(lgWeatherAnimation)


        binding.button.setOnClickListener {
            fragViewModel.setCurrentWeatherData(binding.weatherNum.text.toString())
        }

        fragViewModel.weatherDataToObserve.observe(viewLifecycleOwner) {
            lgWeatherAnimation.doSmth(it.toString(), arrayOf(binding.sunAniImage, binding.sunBlickImage))
        }
    }


//    + "clear-day" -> icon = "00"
//    + "clear-night" -> icon = "01"
//    + "partly-cloudy-day" -> icon = "10"
//    + "partly-cloudy-night" -> icon = "11"
//    + "cloudy" -> icon = "02"
//    + "fog" -> icon = "03"
//      "tornado" -> icon = "04"
//    + "thunderstorm" -> icon = "07"
//    + "rain" -> icon = "09"
//    + "sleet" -> icon = "12"
//    + "snow" -> icon = "14"
//      "wind" -> icon = "21"
//    + "hail" -> icon = "22"
}