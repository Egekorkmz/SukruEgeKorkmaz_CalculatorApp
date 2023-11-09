package com.example.sukruegekorkmaz_hw1

import CustomBlink
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import java.nio.channels.SeekableByteChannel
import java.util.Collections


class MainActivity : AppCompatActivity() {
    lateinit var sbBlink : SeekBar
    lateinit var spCourse : Spinner

    lateinit var course : ArrayList<Cources>
    lateinit var adapter: CustomSpinnerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareTest()

        //remove status and action bar
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        sbBlink = findViewById(R.id.sbBlink)
        spCourse = findViewById<Spinner>(R.id.spCourse)

        adapter = CustomSpinnerAdapter(this, course)
        spCourse.adapter = adapter

        var cb = CustomBlink(findViewById<TextView>(R.id.blink))
        cb.blink()


        sbBlink.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                cb.setDuraion(progress)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

    }
    fun prepareTest(){
        course = ArrayList()
        Collections.addAll<Cources>(
            course,Cources("CTIS 487", R.drawable.android), Cources("CTIS 262", R.drawable.cisco), Cources("CTIS 365", R.drawable.r)
        )
    }
}
