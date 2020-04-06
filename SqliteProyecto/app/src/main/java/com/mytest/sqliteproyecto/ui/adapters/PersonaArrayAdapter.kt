package com.mytest.sqliteproyecto.ui.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.mytest.sqliteproyecto.dal.dto.Persona

class PersonaArrayAdapter(context: Context, resource: Int, objects: MutableList<Persona>) :
    ArrayAdapter<Persona>(context, resource, objects)
