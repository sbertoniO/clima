package com.example.anzen.clima

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {

    val TAG = "com.example.anzen.clima.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val bMexico = findViewById<Button>(R.id.button)
        val bBerlin = findViewById<Button>(R.id.button2)

        bMexico.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this,"Ciudad de México", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"ciudad-mexico")
            startActivity(intent)
        })

        bBerlin.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this,"Ciudad de Berlin", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"ciudad-berlin")
            startActivity(intent)
        })

    }
}
