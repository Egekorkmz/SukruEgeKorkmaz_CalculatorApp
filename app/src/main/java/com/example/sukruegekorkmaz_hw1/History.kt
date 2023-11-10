package com.example.sukruegekorkmaz_hw1

import Structures.Hist
import Structures.Node
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Collections
import kotlin.random.Random

class History : AppCompatActivity() {
    lateinit var tvHistory: TextView
    lateinit var btnRandDia : Button
    lateinit var randDialog: Dialog

    var tempString : String = ""
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        createNode()

        tvHistory = findViewById(R.id.tvHistory)
        btnRandDia = findViewById(R.id.btnRadnDia)


        for(item in Hist.HistoryArray) {
            index ++
            tempString += "$index.${item.code} --- Result : ${item.result}\n"
        }

        tvHistory.text = tempString

        btnRandDia.setOnClickListener{
            createRandDailog()
        }

    }
    fun createRandDailog() {
        if(index >= 0) {
            var randIndex = Random.nextInt(0, index)

            randDialog = Dialog(this)
            randDialog.setContentView(R.layout.rand_dialog)


            var tvIndex = randDialog!!.findViewById<TextView>(R.id.tvRandDiaIndex)
            var tvText = randDialog!!.findViewById<TextView>(R.id.tvRandDiaText)
            var btnCancel = randDialog!!.findViewById<Button>(R.id.btnRandDiaExit)

            tvIndex.text = (randIndex+1).toString()
            tvText.text = Hist.HistoryArray.get(randIndex).toString()

            btnCancel.setOnClickListener {
                //customDialog.hide();
                randDialog!!.dismiss()
            }

            randDialog.show()
        }
        else
            Toast.makeText(this, "There is no record.", Toast.LENGTH_LONG).show()
    }

    fun createNode(){
        Hist.HistoryArray.add(Node("CTIS 487", 55.0))
        Hist.HistoryArray.add(Node("CTIS 487", 48.8))
    }
}