package com.example.hilossegundotrimestre.Bestiario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.hilossegundotrimestre.R
import com.google.android.material.slider.Slider

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        iniciarInterfaz()
    }
    private lateinit var atvNombre: AutoCompleteTextView
    private lateinit var matvEspecie: MultiAutoCompleteTextView
    private lateinit var cbPequeno: CheckBox
    private lateinit var cbGrande: CheckBox
    private lateinit var cvFuego: CardView
    private lateinit var cvAgua: CardView
    private lateinit var cvRayo: CardView
    private lateinit var cvHielo: CardView
    private lateinit var cvSin: CardView
    private lateinit var cvDraco: CardView
    private lateinit var tvNivelHostil: TextView
    private lateinit var slHostilidad: Slider
    private lateinit var btBuscar: Button

    private var nivelHostilidad:Int = 0
    private var nombre: Array<String>? = null
    private var adaptadorNombre: ArrayAdapter<String>? = null
    private var especies: Array<String>? = null
    private var adaptadorEspecies: ArrayAdapter<String>? = null

    private var tamano:String = ""
    private var elemento:String = ""


    private fun iniciarInterfaz() {
        iniciarComp()
        iniciarLiseners()
    }

    private fun iniciarComp() {
        nombre = resources.getStringArray(R.array.nombre)
        adaptadorNombre  = ArrayAdapter<String>(this, android.R.layout.select_dialog_item, nombre!!)
        especies = resources.getStringArray(R.array.especies)
        adaptadorEspecies  = ArrayAdapter<String>(this, android.R.layout.select_dialog_item, especies!!)
        atvNombre = findViewById(R.id.atvNombre)
        matvEspecie = findViewById(R.id.atvEspecie)
        cbPequeno = findViewById(R.id.cbPequeño)
        cbGrande = findViewById(R.id.cbGrande)
        cvFuego = findViewById(R.id.cvFuego)
        cvAgua = findViewById(R.id.cvAgua)
        cvRayo = findViewById(R.id.cvRayo)
        cvHielo = findViewById(R.id.cvHielo)
        cvSin = findViewById(R.id.cvSin)
        cvDraco = findViewById(R.id.cvDraco)
        tvNivelHostil = findViewById(R.id.tvNivelHostil)
        slHostilidad = findViewById(R.id.slHostilidad)
        btBuscar = findViewById(R.id.btBuscar)
    }
    private fun iniciarLiseners() {
        atvNombre.setAdapter(adaptadorNombre)
        matvEspecie.setAdapter(adaptadorEspecies)
        matvEspecie.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        cbGrande.setOnClickListener {
            activarGrande()
        }
        cbPequeno.setOnClickListener {
            activarPequeno()
        }
        cvFuego.setOnClickListener {
            activarFuego()
        }
        cvAgua.setOnClickListener {
            activarAgua()
        }
        cvRayo.setOnClickListener {
            activarRayo()
        }
        cvHielo.setOnClickListener {
            activarHielo()
        }
        cvSin.setOnClickListener {
            activarSin()
        }
        cvDraco.setOnClickListener {
            activarDraco()
        }
        slHostilidad.addOnChangeListener{_, value, _ ->
            nivelHostilidad = value.toInt()
            sliderHostil(nivelHostilidad)
        }
        btBuscar.setOnClickListener {
            val nombre = atvNombre.text.toString()
            val especie = matvEspecie.text.toString()
            navegar(nombre, especie, tamano, elemento, nivelHostilidad)
        }

    }
    private fun sliderHostil(value: Int) {
        when (value) {
            0 -> tvNivelHostil.text = getString(R.string.RC0)
            1 -> tvNivelHostil.text = getString(R.string.RC1)
            2 -> tvNivelHostil.text = getString(R.string.RC2)
            3 -> tvNivelHostil.text = getString(R.string.RC3)
            4 -> tvNivelHostil.text = getString(R.string.RC4)
            5 -> tvNivelHostil.text = getString(R.string.RC5)
            6 -> tvNivelHostil.text = getString(R.string.RC6)
            7 -> tvNivelHostil.text = getString(R.string.RC7)
            8 -> tvNivelHostil.text = getString(R.string.RC8)
            9 -> tvNivelHostil.text = getString(R.string.RC9)
            10 -> tvNivelHostil.text = getString(R.string.RC10)
        }

    }

    private fun activarGrande() {
        tamano = if (tamano.contains("Grande")) {
            tamano.replace("Grande", "")
        } else {
            tamano + "Grande"
        }
    }

    private fun activarPequeno() {
        tamano = if (tamano.contains("Pequeño")) {
            tamano.replace("Pequeño", "")
        } else {
            tamano + "Pequeño"
        }
    }

    private fun activarFuego() {
        cvFuego.radius = resources.getDimension(R.dimen.corner_radius)
        if (elemento.contains("Fuego")) {
            cvFuego.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoFuego))
            elemento = elemento.replace("Fuego","")
        } else {
            cvFuego.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoFuegoSelect))
            elemento += "Fuego"
        }
    }
    private fun activarAgua() {
        cvAgua.radius = resources.getDimension(R.dimen.corner_radius)
        if (elemento.contains("Agua")) {
            cvAgua.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoAgua))
            elemento = elemento.replace("Agua","")
        } else {
            cvAgua.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoAguaSelect))
            elemento += "Agua"
        }
    }
    private fun activarRayo() {
        cvRayo.radius = resources.getDimension(R.dimen.corner_radius)
        cvRayo.radius = resources.getDimension(R.dimen.corner_radius)
        if (elemento.contains("Rayo")) {
            cvRayo.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoRayo))
            elemento = elemento.replace("Rayo","")
        } else {
            cvRayo.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoRayoSelect))
            elemento += "Rayo"
        }
    }
    private fun activarHielo() {
        cvHielo.radius = resources.getDimension(R.dimen.corner_radius)
        if (elemento.contains("Hielo")) {
            cvHielo.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoHielo))
            elemento = elemento.replace("Hielo","")
        } else {
            cvHielo.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoHieloSelect))
            elemento += "Hielo"
        }
    }
    private fun activarSin() {
        cvHielo.radius = resources.getDimension(R.dimen.corner_radius)
        if (elemento.contains("Sin elemento")) {
            cvSin.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoSin))
            elemento = elemento.replace("Sin elemento","")
        } else {
            cvSin.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoSinSelect))
            elemento += "Sin elemento"
        }
    }
    private fun activarDraco() {
        cvDraco.radius = resources.getDimension(R.dimen.corner_radius)
        if (elemento.contains("Draco")) {
            cvDraco.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoDraco))
            elemento = elemento.replace("Draco","")
        } else {
            cvDraco.setBackgroundColor(ContextCompat.getColor(this,R.color.fondoDracoSelect))
            elemento += "Draco"
        }
    }

    private fun navegar(nombre:String, especie:String, tamano:String, elemento:String, hostil:Int) {

        val intentResultado = Intent(this, ListaActivity::class.java)
        intentResultado.putExtra("Nombre", nombre)
        intentResultado.putExtra("Especie", especie)
        intentResultado.putExtra("Tamaño", tamano)
        intentResultado.putExtra("Elemento", elemento)
        intentResultado.putExtra("Hostilidad", hostil)
        startActivity(intentResultado)
    }

}