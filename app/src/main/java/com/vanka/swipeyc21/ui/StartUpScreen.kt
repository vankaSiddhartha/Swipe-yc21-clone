package com.vanka.swipeyc21.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.vanka.swipeyc21.MainActivity
import com.vanka.swipeyc21.R
import com.vanka.swipeyc21.ui.auth.OnBoardingActivity
import com.vanka.swipeyc21.ui.forms.FormsActivity

class StartUpScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_up_screen)
        Handler(mainLooper).postDelayed({
                                        startActivity(Intent(this,FormsActivity()::class.java));
        },1000)
    }
}