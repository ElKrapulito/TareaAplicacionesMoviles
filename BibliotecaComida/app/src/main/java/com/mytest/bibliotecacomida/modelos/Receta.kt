package com.mytest.bibliotecacomida.modelos


import java.io.Serializable


data class Receta(
        val title: String,
        val image:String,
        var url:String,
        val summary:String
    ):Serializable




