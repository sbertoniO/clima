package com.example.anzen.clima

class ciudad (name:String, weather:ArrayList<Weather>?, main:Main){

    var name:String = ""
    var weather:ArrayList<Weather>? = null
    var main:Main? = null

    init {
        this.name = name
        this.weather = weather
        this.main = main
    }

}