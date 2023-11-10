package com.example.sukruegekorkmaz_hw1

import Structures.Hist
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class History : AppCompatActivity() {
    lateinit var tvHistory: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        tvHistory = findViewById(R.id.tvHistory)

        var tempString : String = ""
        var index = 0
        for(item in Hist.HistoryArray) {
            index ++
            tempString += "$index.${item.code} --- Result : ${item.result}\n"
        }

        tvHistory.text = tempString
    }
}