package com.example.hilossegundotrimestre.Bestiario

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.Switch
import com.example.hilossegundotrimestre.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.imageview.ShapeableImageView

class OpinionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opinion)

        iniciarComp()
        iniciarLiseners()
        npRC.maxValue = 999
        npRC.minValue = 1

        val especies = listOf("Herbivoro", "Neopteron", "Carapaceon", "Temnoceran", "Bestia Colmillos", "Wyvern Colmillos", "Anfibio", "Wyvern Serpiente", "Wyvern Nadadores", "Wyvern Bruto", "Wyvern Pájaro", "Wyvern Volador", "Desconocido", "Dragón Anciano", "Dragón Negro")

        for (i in 0 until cgEspecie.childCount) {
            val chip = cgEspecie.getChildAt(i) as Chip
            chip.text = especies[i]
            chip.tag = especies[i]
            chip.isCheckable = true
        }
    }
    private lateinit var etNombre: EditText
    private lateinit var rgSexo: RadioGroup
    private lateinit var npRC: NumberPicker
    private lateinit var rbGusto: RatingBar
    private lateinit var clCalendario: CalendarView
    private lateinit var cgEspecie: ChipGroup
    private lateinit var stVolver:Switch
    private lateinit var siNo: ShapeableImageView
    private lateinit var siSi: ShapeableImageView
    private lateinit var siMal: ShapeableImageView
    private lateinit var siTieso: ShapeableImageView
    private lateinit var siFeli: ShapeableImageView
    private lateinit var btEnviar: Button
    var sexo:String = ""
    var gusto:Int = 0
    var rc:Int = 0
    var calendario:String = ""
    var especie:String = ""
    var volver:String = "No"

    private fun iniciarComp() {
        etNombre = findViewById(R.id.etNombre)
        rgSexo = findViewById(R.id.rgSexo)
        npRC = findViewById(R.id.npRC)
        rbGusto = findViewById(R.id.rbGusto)
        clCalendario = findViewById(R.id.clCalendario)
        cgEspecie = findViewById(R.id.cgEspecie)
        stVolver = findViewById(R.id.stVolver)
        siNo = findViewById(R.id.siNo)
        siSi = findViewById(R.id.siSi)
        btEnviar = findViewById(R.id.btEnviar)
        siMal = findViewById(R.id.siMal)
        siTieso = findViewById(R.id.siTieso)
        siFeli = findViewById(R.id.siFeli)
    }

    private fun iniciarLiseners() {
        rbGusto.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            gusto = rating.toInt()
            if (gusto in 0..2) {
                siMal.visibility = View.VISIBLE
                siTieso.visibility = View.GONE
                siFeli.visibility = View.GONE
            } else if (gusto in 3..4) {
                siMal.visibility = View.GONE
                siTieso.visibility = View.VISIBLE
                siFeli.visibility = View.GONE
            } else {
                siMal.visibility = View.GONE
                siTieso.visibility = View.GONE
                siFeli.visibility = View.VISIBLE
            }
        }
        rgSexo.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)

            sexo = when (radioButton.id) {
                R.id.rbHombre -> "Hombre"
                R.id.rbMujer -> "Mujer"
                else -> ""
            }
        }
        npRC.setOnValueChangedListener { picker, oldVal, newVal ->
            Log.d("NumberPicker", "Tu rango de cazador es: $newVal")
            rc = newVal
        }
        clCalendario.setOnDateChangeListener { view, year, month, dayOfMonth ->
            calendario = "$dayOfMonth/$month/$year"
        }
        cgEspecie.setOnCheckedChangeListener  { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            if (chip != null && chip.isChecked) {
                especie = chip.tag as String
                Log.d("Chips", "Especie seleccionada: $especie")
            }
        }
        stVolver.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                siNo.visibility = View.GONE
                siSi.visibility = View.VISIBLE
                Log.d("Switch", "Que bueno es escuchar que volverias")
                volver = "Si"
            } else {
                siNo.visibility = View.VISIBLE
                siSi.visibility = View.GONE
                Log.d("Switch", "Vaya pensé que te gusto nuestra app")
                volver = "No"
            }
        }
        btEnviar.setOnClickListener {
            var nombre = etNombre.text.toString()
            navegar(nombre,sexo, gusto, rc, calendario, especie, volver)
        }
    }

    private fun navegar(nombre:String,sexo: String, gusto: Int, rc: Int, calendario: String, especie: String, volver: String) {
        val intentResultado = Intent(this, FinaleActivity::class.java)
        intentResultado.putExtra("nombre", nombre)
        intentResultado.putExtra("sexo", sexo)
        intentResultado.putExtra("gusto", gusto)
        intentResultado.putExtra("rc", rc)
        intentResultado.putExtra("calendario", calendario)
        intentResultado.putExtra("especie", especie)
        intentResultado.putExtra("volver", volver)
        startActivity(intentResultado)
    }
}