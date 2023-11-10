package com.example.sukruegekorkmaz_hw1

import CustomBlink
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import androidx.core.view.get
import java.nio.channels.SeekableByteChannel
import java.util.Collections


class MainActivity : AppCompatActivity() {
    lateinit var sbBlink : SeekBar
    lateinit var spCourse : Spinner
    lateinit var btnHist : Button
    lateinit var btnGoCalc : Button

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
        spCourse = findViewById(R.id.spCourse)
        btnHist = findViewById(R.id.btnHistory)
        btnGoCalc = findViewById(R.id.btnGoCalc)

        var pos : Int = 0

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

        spCourse.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected( parent: AdapterView<*>?,view: View,position: Int,id: Long) {
                pos = position
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        btnGoCalc.setOnClickListener {
            var intent: Intent? = null
            var temp : Int = spCourse.id

            intent = Intent(this@MainActivity, GradeCalc::class.java)
            intent.putExtra("selection", temp)
            intent.putExtra("object", course.get(pos))

            startActivity(intent)
        }

        btnHist.setOnClickListener{
            var intent: Intent?= null
            intent = Intent(this@MainActivity, History::class.java)

            startActivity(intent)
        }

    }
    fun prepareTest(){
        course = ArrayList()
        Collections.addAll<Cources>(
            course,Cources("CTIS 487", R.drawable.android), Cources("CTIS 262", R.drawable.cisco), Cources("CTIS 365", R.drawable.r)
        )
        for(temp in course){
            Log.d("Array list", "${temp.toString()}")
        }
    }
}
