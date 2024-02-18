package com.example.hilossegundotrimestre.Bestiario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.hilossegundotrimestre.R

class FinaleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finale)
        iniciarComp()
        iniciarLiseners()
        val gus = intent.getIntExtra("gusto", 0)
        val esp = intent.getStringExtra("especie")
        val fech = intent.getStringExtra("calendario")
        val rang = intent.getIntExtra("rc", 0)
        val volv = intent.getStringExtra("volver")
        val nombre = intent.getStringExtra("nombre")
        val sexo = intent.getStringExtra("sexo")

        tvNombre.text = nombre
        tvSexo.text = sexo
        tvGusto.text = gus.toString()
        tvFecha.text = fech.toString()
        tvRangoCazador.text = rang.toString()
        tvEspecieF.text = esp
        tvVolver.text = volv

    }
    private lateinit var tvNombre: TextView
    private lateinit var tvSexo: TextView
    private lateinit var btInicio: Button
    private lateinit var tvGusto: TextView
    private lateinit var tvFecha: TextView
    private lateinit var tvRangoCazador: TextView
    private lateinit var tvEspecieF: TextView
    private lateinit var tvVolver: TextView

    private fun iniciarComp() {
        tvNombre = findViewById(R.id.tvNombre)
        tvSexo = findViewById(R.id.tvSexo)
        tvGusto = findViewById(R.id.tvGusto)
        tvFecha = findViewById(R.id.tvFecha)
        tvRangoCazador = findViewById(R.id.tvRangoCazador)
        tvEspecieF = findViewById(R.id.tvEspecieF)
        tvVolver = findViewById(R.id.tvVolver)
        btInicio = findViewById(R.id.btInicio)
    }

    private fun inicio() {
        val intent = Intent(this,PrincipalActivity::class.java)
        startActivity(intent)
    }

    private fun iniciarLiseners() {
        btInicio.setOnClickListener {
            inicio()
        }
    }
}