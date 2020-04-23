package com.mytest.agendita.ui.adpters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.mytest.agendita.R
import com.mytest.agendita.tables.Phone

class PhoneAdapter(context: Context, resource: Int, objects: MutableList<Phone>, private val phoneListener:PhoneClickListener) :
    ArrayAdapter<Phone>(context, resource, objects) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val container = inflater.inflate(R.layout.phone_item, parent, false) as View

        val txtPhoneNum = container.findViewById<TextView>(R.id.txtNum)
        val txtType = container.findViewById<TextView>(R.id.txtType)
        val btnEdit = container.findViewById<ImageButton>(R.id.btnEditPhone)
        val btnDelete = container.findViewById<ImageButton>(R.id.btnDeletePhone)

        val phone = getItem(position)
        if (phone != null) {
            txtPhoneNum.text = phone.number.toString()
            txtType.text = phone.type.toString()
            btnEdit.setOnClickListener {
                phoneListener.phoneUpdated(phone)
            }
            btnDelete.setOnClickListener {
                phoneListener.phoneDeleted(phone)
            }

        }

        return container
    }

    interface PhoneClickListener {
        fun phoneDeleted(phone: Phone)
        fun phoneUpdated(phone: Phone)
    }

}