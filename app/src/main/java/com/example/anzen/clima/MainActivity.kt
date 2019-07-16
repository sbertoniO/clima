package com.example.anzen.clima

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
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

        if (Network.hayRed(this)){
            //ejecutar solicitud http
            //a9e65d6b1ab0553c4e39e0168add4b55
            //3530597
            solicitudHTTPVolley("https://api.openweathermap.org/data/2.5/weather?id=$ciudad&appid=a9e65d6b1ab0553c4e39e0168add4b55&units=metric&lang=es")
        }else{
            Toast.makeText(this,"No estas conectado a la red",Toast.LENGTH_SHORT).show()
        }


        /*
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
        }*/


    }

    //Metodo volley
    private fun solicitudHTTPVolley(url:String){

        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{
            response ->
            try {
                Log.d("solicitudHTTPVolley", response)
                val gson = Gson()
                val ciudad = gson.fromJson(response, ciudad::class.java)
                tvGrados?.text = ciudad.main?.temp.toString() + "°"
                tvCiudad?.text = ciudad.name
                tvEstatus?.text = ciudad.weather?.get(0)?.description

            }catch(e:Exception){

            }
        }, Response.ErrorListener {  })

        queue.add(solicitud)

    }

}
