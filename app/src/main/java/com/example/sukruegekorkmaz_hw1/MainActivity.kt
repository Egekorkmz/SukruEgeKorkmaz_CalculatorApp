package com.example.sukruegekorkmaz_hw1

import CustomBlink
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //remove status and action bar
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        var cb = CustomBlink(findViewById<TextView>(R.id.blink))
        cb.blink()

        findViewById<Button>(R.id.button1).setOnClickListener({cb.setDuraion(2000)})
    }
}