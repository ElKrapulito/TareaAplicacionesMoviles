package com.mytest.practicalistaconitem.adapters


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.mytest.practicalistaconitem.R
import com.mytest.practicalistaconitem.models.Persona

class ContactoArrayAdapter(context: Context, resource: Int, objects: Array<out Persona>) :
    ArrayAdapter<Persona>(context, resource, objects) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val contenedor = inflater.inflate(R.layout.lista_contactos_item, parent,false)
        val persona = getItem(position) ?: return super.getView(position, convertView, parent)
        val lblNombre =  contenedor.findViewById<TextView>(R.id.lblNombre)
        val lblTelefono =  contenedor.findViewById<TextView>(R.id.lblTelefono)
        val lblDireccion = contenedor.findViewById<TextView>(R.id.lblDireccion)


        lblNombre.text = "${persona.nombre} ${persona.apellids}"
        lblTelefono.text = "${persona.telefono}"
        lblDireccion.text = "${persona.direccion}"

        return contenedor
    }



}