package com.example.sukruegekorkmaz_hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var isBlinking = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //remove status and action bar
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        //blink animation create
        val blinkAnimation = AlphaAnimation(1f, 0f)
        blinkAnimation.duration = 1000 // Set the duration of the animation in milliseconds
        blinkAnimation.repeatCount = Animation.INFINITE // Infinite blinking

        // Set an AnimationListener to toggle the visibility of the TextView
        blinkAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                // Toggle visibility when the animation ends
                findViewById<TextView>(R.id.blink).visibility = if (isBlinking) View.VISIBLE else View.INVISIBLE
                isBlinking = !isBlinking
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        findViewById<TextView>(R.id.blink).startAnimation(blinkAnimation)
    }
}