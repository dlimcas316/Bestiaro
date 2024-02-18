package com.example.hilossegundotrimestre.Bestiario

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Video
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import com.example.hilossegundotrimestre.R
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.ShapeAppearanceModel

class DetallesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        val monstruo = intent.getSerializableExtra("monstruo") as item_Monstruo
        iniciarComp()
        var mcIntro = MediaController(this)
        mcIntro.setAnchorView(vvIntro)
        var path = "android.resource://" + packageName + "/" + monstruo.intro
        vvIntro.setVideoURI(Uri.parse(path))
        vvIntro.setMediaController(mcIntro)
        tvNombre.text = monstruo.nombre
        tvEspecie.text = monstruo.especies
        tvTamaño.text = monstruo.tamano
        tvElemento.text = monstruo.elemento
        tvDescripcion.text = monstruo.descrip
        hostilidad(monstruo.hostil)
        ibIcon.setImageResource(monstruo.icon!!)
        iniciarLiseners()
    }

    private lateinit var tvNombre:TextView
    private lateinit var tvEspecie:TextView
    private lateinit var tvTamaño:TextView
    private lateinit var tvElemento:TextView
    private lateinit var tvDescripcion:TextView
    private lateinit var tvHostilidad:TextView
    private lateinit var ibIcon: ImageButton
    private lateinit var btInicio: Button
    private lateinit var btVuelta: Button
    private lateinit var btOpinion: Button
    private lateinit var vvIntro: VideoView

    private fun iniciarComp() {
        tvNombre = findViewById(R.id.tvNombre)
        tvEspecie = findViewById(R.id.tvEspecie)
        tvTamaño = findViewById(R.id.tvTamaño)
        tvElemento = findViewById(R.id.tvElemento)
        tvDescripcion = findViewById(R.id.tvDescripcion)
        tvHostilidad = findViewById(R.id.tvHostilidad)
        ibIcon = findViewById(R.id.ibIcon)
        btInicio = findViewById(R.id.btInicio)
        btVuelta = findViewById(R.id.btVuelta)
        btOpinion = findViewById(R.id.btOpinion)
        vvIntro = findViewById(R.id.vvIntro)
    }
    private fun hostilidad(value:Int) {
        when (value) {
            1 -> tvHostilidad.text = getString(R.string.RC1)
            2 -> tvHostilidad.text = getString(R.string.RC2)
            3 -> tvHostilidad.text = getString(R.string.RC3)
            4 -> tvHostilidad.text = getString(R.string.RC4)
            5 -> tvHostilidad.text = getString(R.string.RC5)
            6 -> tvHostilidad.text = getString(R.string.RC6)
            7 -> tvHostilidad.text = getString(R.string.RC7)
            8 -> tvHostilidad.text = getString(R.string.RC8)
            9 -> tvHostilidad.text = getString(R.string.RC9)
            10 -> tvHostilidad.text = getString(R.string.RC10)
        }
    }
    private fun vuelta() {
        val intent = Intent(this,ListaActivity::class.java)
        startActivity(intent)
    }
    private fun inicio() {
        val intent = Intent(this,PrincipalActivity::class.java)
        startActivity(intent)
    }
    private fun opinion() {
        val intent = Intent(this,OpinionActivity::class.java)
        startActivity(intent)
    }
    private fun iniciarLiseners() {
        btVuelta.setOnClickListener {
            vuelta()
        }
        btInicio.setOnClickListener {
            inicio()
        }
        btOpinion.setOnClickListener {
            opinion()
        }
    }


}