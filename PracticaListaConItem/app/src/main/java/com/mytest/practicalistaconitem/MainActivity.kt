package com.mytest.practicalistaconitem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mytest.practicalistaconitem.adapters.ContactoArrayAdapter
import com.mytest.practicalistaconitem.models.Persona
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : ContactoArrayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datos = arrayOf(
            Persona(1,"Samuel","Cordova","123456789","Por ahi"),
            Persona(2,"Andres","Baldivieso","987654321","Casita"),
            Persona(3,"Rene","Cordova","73456782","Por ahi"),
            Persona(4,"Ana Maria","Baldivieso","987623546","A lado tuyo"),
            Persona(5,"Sam","Cordova","12359763","Plan 3000"),
            Persona(6,"Karina","Paz","7645689023","A lado tuyo"),
            Persona(1,"Samuel","Cordova","123456789","Plan 3000"),
            Persona(2,"Andres","Baldivieso","987654321","Por ahi"),
            Persona(3,"Rene","Cordova","73456782","Por ahi"),
            Persona(4,"Ana Maria","Baldivieso","987623546","Casita"),
            Persona(5,"Sam","Cordova","12359763","Plan 3000"),
            Persona(6,"Karina","Paz","7645689023","A lado tuyo"),
            Persona(1,"Samuel","Cordova","123456789","Por ahi"),
            Persona(2,"Andres","Baldivieso","987654321","Por ahi"),
            Persona(3,"Rene","Cordova","73456782","Casita"),
            Persona(4,"Ana Maria","Baldivieso","987623546","Por ahi"),
            Persona(5,"Sam","Cordova","12359763","Por ahi"),
            Persona(6,"Karina","Paz","7645689023","Plan 3000")

        )

        adapter = ContactoArrayAdapter(this, R.layout.lista_contactos_item ,datos)
        lstContactos.adapter = adapter

        lstContactos.setOnItemClickListener { _, _, position, _ ->
            val persona = adapter.getItem(position) ?: return@setOnItemClickListener
            Toast.makeText(this,"${persona.nombre} ${persona.apellids}",Toast.LENGTH_SHORT).show()
        }

    }
}
