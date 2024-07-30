package com.vanka.swipeyc21.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.denzcoskun.imageslider.ImageSlider
import androidx.navigation.fragment.findNavController

import com.denzcoskun.imageslider.models.SlideModel
import com.vanka.swipeyc21.R
import com.vanka.swipeyc21.databinding.ActivityMainContainerBinding
import com.vanka.swipeyc21.ui.main.fragments.HomeFragment

class MainContainerActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainContainerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

   navigateToNewFragment()
    }

    private fun navigateToNewFragment() {
        val newFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, newFragment)
            .addToBackStack(null)
            .commit()
    }
}