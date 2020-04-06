package com.mytest.sqliteproyecto.dal.connection

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Connection(
    context: Context?
) : SQLiteOpenHelper(context, DATABASE_NAME, null ,DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE personas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "nombres TEXT NOT NULL," +
                "apellidos TEXT NOT NULL," +
                "ciudad TEXT NOT NULL," +
                "edad INTEGER," +
                "fechaNacimiento TEXT" +
                ")")
        db?.execSQL("CREATE TABLE telefonos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "telefono TEXT NOT NULL," +
                "personaId INTEGER NOT NULL," +
                "FOREIGN KEY (personaId) REFERENCES personas(id)" +
                ")")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    companion object {
        private var INSTANCE : Connection? = null

        fun getInstance(context: Context): Connection {
            if(INSTANCE == null){
                INSTANCE = Connection(context)
            }
            return this.INSTANCE!!
        }

        const val DATABASE_NAME = "com.mytest.sqliteproyecto.pruebapersonas"
        const val DATABASE_VERSION = 1
    }
}