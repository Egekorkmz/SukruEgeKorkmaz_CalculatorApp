package com.example.sukruegekorkmaz_hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class GradeCalc : AppCompatActivity() {
    lateinit var etnMT1 : EditText
    lateinit var etnMT2 : EditText
    lateinit var etnProject : EditText
    lateinit var etnFinal : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade_calc)

        etnMT1 = findViewById(R.id.etnMT1)
        etnMT2 = findViewById(R.id.etnMT2)
        etnProject = findViewById(R.id.etnProject)
        etnFinal = findViewById(R.id.etnFinal)


    }

    fun gradeCalc(MT1: Int = 0, MT2: Int = 0, Project: Int = 0, Final: Int = 0): Double {
        return MT1 * 0.25 + MT2 * 0.25 + Project * 0.1 + Final * 0.4
    }
}