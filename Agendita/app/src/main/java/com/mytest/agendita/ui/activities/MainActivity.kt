package com.mytest.agendita.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mytest.agendita.R
import com.mytest.agendita.conn.AgendaDatabase
import com.mytest.agendita.tables.Contact
import com.mytest.agendita.ui.adpters.ContactAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ContactAdapter.ContactClickListener {
    lateinit var adapter:ContactAdapter
    lateinit var db:AgendaDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AgendaDatabase.getInstance(this)

        loadData()
        setupListeners()
    }

    private fun loadData() {
        val listaContactos = db.contactDao().getAll() as ArrayList
        adapter =
            ContactAdapter(this, android.R.layout.simple_list_item_1, listaContactos, this)
        lstContacts.adapter = adapter
    }

    private fun setupListeners() {
        btnAdd.setOnClickListener {
            val intent = Intent(this, FormContact::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    override fun contactDeleted(contact: Contact) {
        db.contactDao().delete(contact)
        loadData()
    }

    override fun contactUpdated(contact: Contact) {
        val intent = Intent(this, FormContact::class.java)
        intent.putExtra("id", contact.id)
        startActivity(intent)
    }

}
