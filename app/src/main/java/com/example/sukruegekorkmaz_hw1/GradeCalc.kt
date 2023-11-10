package com.example.sukruegekorkmaz_hw1

import Structures.Hist
import Structures.Node
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class GradeCalc : AppCompatActivity() {
    lateinit var etnMT1 : EditText
    lateinit var etnMT2 : EditText
    lateinit var etnProject : EditText
    lateinit var etnFinal : EditText
    lateinit var btnCalc : Button
    lateinit var tempIntent : Intent
    lateinit var cource : Cources
    lateinit var tvCourse : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade_calc)

        etnMT1 = findViewById(R.id.etnMT1)
        etnMT2 = findViewById(R.id.etnMT2)
        etnProject = findViewById(R.id.etnProject)
        etnFinal = findViewById(R.id.etnFinal)
        btnCalc = findViewById(R.id.btnCalc)
        tvCourse = findViewById(R.id.tvCourseCode)
        tempIntent = intent

        cource = tempIntent.getParcelableExtra<Cources>("object")!!
        tvCourse.text = cource.getCode()

        btnCalc.setOnClickListener{
            if(etnMT1.text.isEmpty() || etnMT2.text.isEmpty() || etnProject.text.isEmpty() || etnFinal.text.isEmpty()){
                Toast.makeText(this,"Fill all spaces !!!", Toast.LENGTH_LONG).show()
            }
            else {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Calculation Result")
                var result = gradeCalc(
                    etnMT1.text.toString().toInt(),
                    etnMT2.text.toString().toInt(),
                    etnProject.text.toString().toInt(),
                    etnFinal.text.toString().toInt()
                )
                alert.setMessage("Your result is $result")
                alert.show()

                Hist.HistoryArray.add(Node("${cource.getCode()}", result))
            }
        }
    }

    fun gradeCalc(mT1: Int = 0, mT2: Int = 0, project: Int = 0, final: Int = 0): Double {
        return mT1 * 0.25 + mT2 * 0.25 + project * 0.1 + final * 0.4
    }
}