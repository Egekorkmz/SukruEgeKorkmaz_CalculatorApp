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

class CustomSpinnerAdapter(var contextt: Context, var spinnerItemValues: ArrayList<Social>)
    : ArrayAdapter<Courses>(contextt, R.layout.spinner_item, spinnerItemValues)
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
        val imgItemSocial:ImageView = view.findViewById(R.id.imgItemSocial)
        val tvItemSocialName:TextView = view.findViewById(R.id.tvItemSocialName)

        val selectedSocial = spinnerItemValues.get(position)
        tvItemSocialName.text = selectedSocial.getName()
        imgItemSocial.setImageResource(selectedSocial.getImgId())
        if (position % 2 == 0)
            constraintLayout.setBackgroundColor(Color.BLUE)
        else
            constraintLayout.setBackgroundColor(Color.YELLOW)
        return view
    }
}
