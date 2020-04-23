package com.mytest.agendita.conn

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mytest.agendita.dao.ContactDao
import com.mytest.agendita.dao.PhoneDao
import com.mytest.agendita.tables.Contact
import com.mytest.agendita.tables.Phone

@Database(entities = arrayOf(Contact::class,Phone::class), version = 1,exportSchema = false)
abstract class AgendaDatabase() : RoomDatabase() {
    abstract fun contactDao():ContactDao
    abstract fun phoneDao():PhoneDao

    companion object {
        private var INSTANCE: AgendaDatabase? = null
        fun getInstance(context: Context): AgendaDatabase {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, AgendaDatabase::class.java, "pruebaroom")
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE!!
        }
    }

}