package com.example.anzen.clima

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvEstatus:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstado)

        val ciudad = intent.getStringExtra("com.example.anzen.clima.ciudades.CIUDAD")

        //Toast.makeText(this,ciudad,Toast.LENGTH_SHORT).show()

        val ciudadmx = ciudad("Ciudad de México", 15, "Lluvioso")
        val ciudadbr = ciudad("Ciudad de Berlín", 30, "Despejado")

        if(ciudad == "ciudad-mexico"){
            //mostrar informacion de ciudad de mexico
            tvGrados?.text = ciudadmx.grados.toString() + "°"
            tvCiudad?.text = ciudadmx.nombre
            tvEstatus?.text = ciudadmx.estatus

        }
        else if(ciudad == "ciudad-berlin"){
            //mostrar informacion de ciudad de berlin
            tvGrados?.text = ciudadbr.grados.toString() + "°"
            tvCiudad?.text = ciudadbr.nombre
            tvEstatus?.text = ciudadbr.estatus
        }
        else{
            Toast.makeText(this, "No se encuentra la información", Toast.LENGTH_SHORT).show()
        }

    }
}
