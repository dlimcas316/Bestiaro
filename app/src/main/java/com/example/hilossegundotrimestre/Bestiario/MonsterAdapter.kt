package com.example.hilossegundotrimestre.Bestiario

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.hilossegundotrimestre.R

class MonsterAdapter(private val myContext: Context, private var listaMonstruos: List<item_Monstruo>) :
    ArrayAdapter<item_Monstruo>(myContext, 0, listaMonstruos) {

    private var listaMonstruosFiltrada: List<item_Monstruo> = listaMonstruos

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = convertView ?: LayoutInflater.from(myContext).inflate(R.layout.item_monstruo, parent, false)
        val animation = AnimationUtils.loadAnimation(myContext,R.anim.face_in)
        if (position < listaMonstruosFiltrada.size) {
            val monstruo = listaMonstruosFiltrada[position]
            layout.findViewById<TextView>(R.id.tvNombre).text = monstruo.nombre
            layout.findViewById<ImageView>(R.id.ivIcon).setImageResource(monstruo.icon!!)
        }
        layout.startAnimation(animation)
        return layout
    }
}
