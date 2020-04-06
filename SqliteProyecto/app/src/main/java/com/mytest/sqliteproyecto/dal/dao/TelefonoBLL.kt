package com.mytest.sqliteproyecto.dal.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.mytest.sqliteproyecto.dal.connection.Connection
import com.mytest.sqliteproyecto.dal.dto.Telefono

class TelefonoBLL {
    companion object{
        @JvmStatic
        fun insert(context : Context, telefono : String, personaId : Int){
            val conexion = Connection(context)
            val values : ContentValues = ContentValues()
            values.put("telefono", telefono)
            values.put("personaId", personaId)
            conexion.writableDatabase.insert(tableName,null, values)
        }
        @JvmStatic
        fun update(context : Context, telefono : String, personaId : Int, id : Int){
            val conexion = Connection(context)
            val values : ContentValues = ContentValues()
            values.put("telefono", telefono)
            values.put("personaId", personaId)
            conexion.writableDatabase.update(tableName, values, "id = ?", arrayOf(id.toString()))
        }
        @JvmStatic
        fun delete(context : Context, id : Int){
            val conexion = Connection(context)
            conexion.writableDatabase.delete(tableName,"id = ?", arrayOf(id.toString()))
        }
        @JvmStatic
        fun selectAll(context : Context): ArrayList<Telefono> {
            val conexion = Connection(context)
            val sql = "SELECT id, telefono, personaId FROM telefonos"
            val cursor = conexion.readableDatabase.rawQuery(sql, arrayOf())
            val telefonos = ArrayList<Telefono>()
            while(cursor.moveToNext()){
                val telefono = getTelefono(cursor)
                telefonos.add(telefono)
            }
            cursor.close()
            return telefonos
        }
        @JvmStatic
        fun select(context : Context, id : Int) : Telefono?{
            val conexion = Connection(context)
            val sql = "SELECT id, telefono, personaId FROM telefonos WHERE id = $id"
            val cursor = conexion.readableDatabase.rawQuery(sql, arrayOf(id.toString()))
            if(cursor.moveToFirst()){
                val telefono = getTelefono(cursor)
                cursor.close()
                return telefono
            }
            cursor.close()
            return null
        }
        @JvmStatic
        fun selectAllbyPersona(context: Context, id : Int): ArrayList<Telefono> {
            val conexion = Connection(context)
            val sql = "SELECT id, telefono, personaId FROM telefonos WHERE personaId = $id"
            val cursor = conexion.readableDatabase.rawQuery(sql, arrayOf())
            val telefonos = ArrayList<Telefono>()
            while(cursor.moveToNext()){
                val telefono = getTelefono(cursor)
                telefonos.add(telefono)
            }
            cursor.close()
            return telefonos
        }

        private fun getTelefono(cursor: Cursor): Telefono {
            val telefono = Telefono(cursor.getInt(0),cursor.getString(1),cursor.getInt(2))
            return telefono
        }

        const val tableName = "telefonos"
    }
}