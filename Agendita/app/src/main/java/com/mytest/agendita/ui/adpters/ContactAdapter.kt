package com.mytest.agendita.ui.adpters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.mytest.agendita.R
import com.mytest.agendita.tables.Contact

class ContactAdapter(context: Context,
                     resource: Int,
                     objects: MutableList<Contact>,
                     private val contactListener: ContactClickListener)
    : ArrayAdapter<Contact>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val container = inflater.inflate(R.layout.contact_item, parent, false) as View

        val lblValue = container.findViewById<TextView>(R.id.lblName)
        val btnDelete = container.findViewById<ImageButton>(R.id.btnDelete)
        val btnEdit = container.findViewById<ImageButton>(R.id.btnEdit)

        val contact = getItem(position)
        if (contact != null) {
            lblValue.text = contact.names.toString()
            btnDelete.setOnClickListener {
                contactListener.contactDeleted(contact)
            }
            btnEdit.setOnClickListener {
                contactListener.contactUpdated(contact)
            }
        }


        return container
    }

    interface ContactClickListener {
        fun contactDeleted(contact: Contact)
        fun contactUpdated(contact: Contact)
    }
}