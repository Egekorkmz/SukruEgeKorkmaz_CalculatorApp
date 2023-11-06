package com.example.sukruegekorkmaz_hw1

import CustomAnimations
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //remove status and action bar
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        CustomAnimations.blink(findViewById(R.id.blink))

    }
}