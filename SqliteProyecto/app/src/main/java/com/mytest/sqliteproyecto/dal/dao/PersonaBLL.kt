package com.mytest.sqliteproyecto.dal.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.mytest.sqliteproyecto.dal.connection.Connection
import com.mytest.sqliteproyecto.dal.dto.Persona

class PersonaBLL {
    companion object {
        @JvmStatic
        fun insert(
            context: Context,
            nombres: String,
            apellidos: String,
            ciudad: String,
            edad: Int,
            fechaNacimiento: String
        ) {
            val conexion = Connection(context)
            val values : ContentValues = ContentValues()
            values.put("nombres", nombres)
            values.put("apellidos", apellidos)
            values.put("ciudad", ciudad)
            values.put("edad", edad)
            values.put("fechaNacimiento", fechaNacimiento)
            conexion.writableDatabase.insert(tableName,null, values)
        }

        @JvmStatic
         fun update(
            context: Context,
            nombres: String,
            apellidos: String,
            ciudad: String,
            edad: Int,
            fechaNacimiento: String,
            id: Int
        ) {
            val conexion = Connection(context)
            val values : ContentValues = ContentValues()
            values.put("nombres", nombres)
            values.put("apellidos", apellidos)
            values.put("ciudad", ciudad)
            values.put("edad", edad)
            values.put("fechaNacimiento", fechaNacimiento)
            conexion.writableDatabase.update(tableName,values,"id = ?", arrayOf(id.toString()))
        }
        @JvmStatic
        fun delete(context: Context, id: Int) {
            val conexion = Connection(context)
            conexion.writableDatabase.delete(tableName,"id = ?", arrayOf(id.toString()))
        }
        @JvmStatic
        fun selectAll(context: Context): ArrayList<Persona> {
            val conexion = Connection(context)
            val sql = "SELECT id, nombres, apellidos, ciudad, edad, fechaNacimiento FROM $tableName"
            val cursor = conexion.readableDatabase.rawQuery(sql, arrayOf())
            val personas = ArrayList<Persona>()
            while (cursor.moveToNext()){
                val persona = rowToDto(cursor)
                personas.add(persona)
            }
            cursor.close()
            return personas
        }
        @JvmStatic
        fun select(context: Context, id: Int) : Persona? {
            val conexion = Connection(context)
            val sql = "SELECT id, nombres, apellidos, ciudad, edad, fechaNacimiento FROM $tableName WHERE id = ?"
            val cursor = conexion.readableDatabase.rawQuery(sql, arrayOf(id.toString()))
            if(cursor.moveToFirst()){
                val persona = rowToDto(cursor)
                cursor.close()
                return persona
            }
            cursor.close()
            return null
        }

        private fun rowToDto(cursor: Cursor): Persona {
            val persona = Persona(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4),
                cursor.getString(5)
            )
            return persona
        }

        const val tableName = "personas"
    }



}