package com.mytest.sqliteproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.mytest.sqliteproyecto.R
import com.mytest.sqliteproyecto.dal.dao.PersonaBLL
import com.mytest.sqliteproyecto.dal.dao.TelefonoBLL
import com.mytest.sqliteproyecto.dal.dto.Telefono
import com.mytest.sqliteproyecto.ui.adapters.PersonaArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var personaAdapter : PersonaArrayAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //PersonaBLL.insert(this, "Sam","Cordova","Santa Cruz",21,"19980531")
        //TelefonoBLL.insert(this,"65060237",1)
        //TelefonoBLL.insert(this,"9548731203",2)
        val listaPersonas = PersonaBLL.selectAll(this)
        personaAdapter = PersonaArrayAdapter(this,android.R.layout.simple_list_item_1,listaPersonas)
        lstPersonas.adapter = personaAdapter

        lstPersonas.setOnItemClickListener { _, _, position, _ ->
            val persona = personaAdapter.getItem(position)
            val telefono : ArrayList<Telefono>
            telefono = TelefonoBLL.selectAllbyPersona(this, persona!!.id)

            Toast.makeText(
                this,
                "${persona?.id} ${persona?.nombres} ${persona?.apellidos} ${telefono.get(0).telefono}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
