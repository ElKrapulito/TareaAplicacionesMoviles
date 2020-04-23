package com.mytest.agendita.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mytest.agendita.R
import com.mytest.agendita.conn.AgendaDatabase
import com.mytest.agendita.tables.Contact
import com.mytest.agendita.tables.Phone
import com.mytest.agendita.tables.Relations.ContactwithPhones
import com.mytest.agendita.ui.adpters.PhoneAdapter
import kotlinx.android.synthetic.main.activity_form_contact.*


class FormContact : AppCompatActivity(), PhoneAdapter.PhoneClickListener {

    private var id: Int = 0
    lateinit var db: AgendaDatabase
    private lateinit var adapter: PhoneAdapter
    lateinit var listPhones:ArrayList<Phone>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_contact)
        db = AgendaDatabase.getInstance(this)

        loadDataFromIntent()
        setupListeners()

    }

    private fun loadDataFromIntent() {
        id = intent.getIntExtra("id", 0)

        val objContact = db.contactDao().getById(id)
        listPhones = ArrayList()
        if (id == 0) {
            adapter =
                PhoneAdapter(this, android.R.layout.simple_list_item_1, listPhones,this)
            lstPhones.adapter = adapter
            return
        }

        listPhones = objContact.phones as ArrayList<Phone>

        txtName.setText(objContact.contact.names)
        txtLastName.setText(objContact.contact.lastname)
        txtAge.setText(objContact.contact.age.toString())
        txtEmail.setText(objContact.contact.email)
        txtimgUrl.setText(objContact.contact.imgUrl)
        txtAddress.setText(objContact.contact.address)
        for (i in 0 until spnCiudades.count) {
            val objCiudad = spnCiudades.getItemAtPosition(i)
            if (objCiudad == objContact.contact.city) {
                spnCiudades.setSelection(i)
                break
            }
        }
        adapter =
            PhoneAdapter(this, android.R.layout.simple_list_item_1, listPhones,this)
        lstPhones.adapter = adapter


    }

    private fun setupListeners() {
        btnSave.setOnClickListener {
            val nombres = txtName.text.toString()
            val apellidos = txtLastName.text.toString()
            val edad = txtAge.text.toString()
            val ciudad = spnCiudades.selectedItem.toString()
            val email = txtEmail.text.toString()
            val address = txtAddress.text.toString()
            val imgurl = txtimgUrl.text.toString()
            val phones: ArrayList<Phone> = ArrayList()
            for (i in 0 until lstPhones.count) {
                val phone = lstPhones.getItemAtPosition(i) as Phone
                phones.add(phone)
            }
            val objContact: ContactwithPhones
            val contact = Contact()
            if (id == 0) {
                contact.names = nombres
                contact.lastname = apellidos
                contact.age = edad.toInt()
                contact.city = ciudad.toString()
                contact.email = email
                contact.address = address
                contact.imgUrl = imgurl

                objContact =
                    ContactwithPhones(contact, phones)
                db.contactDao().insertAll(contact)
            } else {
                contact.id = id
                contact.names = nombres
                contact.lastname = apellidos
                contact.age = edad.toInt()
                contact.city = ciudad
                contact.email = email
                contact.address = address
                contact.imgUrl = imgurl
                objContact =
                    ContactwithPhones(contact, phones)

                /*db.contactDao().update(nombres,
                    apellidos,
                    imgurl,
                    ciudad,
                    edad.toInt(),
                    email,
                    address,
                    id)*/
                db.contactDao().save(contact)
            }
            finish()
        }
        btnCancel.setOnClickListener {
            finish()
        }
        btnAddNum.setOnClickListener{
            val intent = Intent(this, FormPhone::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        loadDataFromIntent()
    }

    override fun phoneDeleted(phone: Phone) {
        db.phoneDao().delete(phone)
        loadDataFromIntent()
    }

    override fun phoneUpdated(phone: Phone) {
        val intent = Intent(this, FormPhone::class.java)
        intent.putExtra("id", id)
        intent.putExtra("phoneId",phone.id)
        startActivity(intent)
    }
}
