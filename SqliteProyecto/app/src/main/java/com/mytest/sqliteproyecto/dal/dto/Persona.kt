package com.mytest.sqliteproyecto.dal.dto

data class Persona(
    val id : Int,
    val nombres : String,
    val apellidos : String,
    val ciudad : String,
    val edad : Int,
    val fechaNacimiento : String
){
    override fun toString(): String {
        return "$nombres $apellidos"
    }

}
