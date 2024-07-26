package com.vanka.swipeyc21.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.vanka.swipeyc21.MainActivity
import com.vanka.swipeyc21.R

class StartUpScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_up_screen)
        Handler(mainLooper).postDelayed({
                                        startActivity(Intent(this,MainActivity::class.java));
        },1000)
    }
}