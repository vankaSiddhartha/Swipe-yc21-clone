package com.vanka.swipeyc21.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vanka.swipeyc21.R
import com.vanka.swipeyc21.databinding.ActivityOnBoardingBinding
import com.vanka.swipeyc21.utils.BottomAuthSheet

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding:ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        binding.button.setOnClickListener {
            val bottomSheetFragment = BottomAuthSheet()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }
        setContentView(binding.root)
    }
}