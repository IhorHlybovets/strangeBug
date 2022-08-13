package com.b3acoc.strangebug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.b3acoc.strangebug.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var weatherBinding: ActivityMainBinding? = null
    private val binding get() = weatherBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        weatherBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, AnimatorFragment())
            .addToBackStack(null).commit()
    }
}