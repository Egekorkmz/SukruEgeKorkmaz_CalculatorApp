package com.example.sukruegekorkmaz_hw1

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.contentValuesOf

class CustomSpinnerAdapter(var contextt: Context, var spinnerItemValues: ArrayList<Cources>)
    : ArrayAdapter<Cources>(contextt, R.layout.spinner_item, spinnerItemValues)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?,parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflator = contextt.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflator.inflate(R.layout.spinner_item, parent, false)

        val constraintLayout:ConstraintLayout = view.findViewById(R.id.itemConstraintLayout)
        val imgCourse:ImageView = view.findViewById(R.id.imgCourse)
        val tvCourseCode:TextView = view.findViewById(R.id.tvCourse)

        val selectedCourse = spinnerItemValues.get(position)
        tvCourseCode.text = selectedCourse.getCode()
        imgCourse.setImageResource(selectedCourse.getImgId())

        if (position % 2 != 0)
            constraintLayout.setBackgroundColor(Color.LTGRAY)

        return view
    }
}
