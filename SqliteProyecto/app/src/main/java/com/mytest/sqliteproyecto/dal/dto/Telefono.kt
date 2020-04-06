package com.mytest.sqliteproyecto.dal.dto

data class Telefono(
    val id : Int,
    val telefono : String,
    val personaId : Int
    ) {
    override fun toString(): String {
        return "$telefono"
    }
}