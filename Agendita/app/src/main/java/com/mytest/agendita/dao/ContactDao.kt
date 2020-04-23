package com.mytest.agendita.dao

import androidx.room.*
import com.mytest.agendita.tables.Contact
import com.mytest.agendita.tables.Relations.ContactwithPhones

@Dao()
interface ContactDao {
    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    @Transaction
    @Query("SELECT * FROM contact")
    fun getAllwithPhones(): List<ContactwithPhones>

    @Query("SELECT * FROM contact WHERE id IN (:contactIds)")
    fun loadAllByIds(contactIds: IntArray): List<Contact>

    @Query("SELECT * FROM contact WHERE names LIKE :first AND " +
            "lastName LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Contact

    @Transaction
    @Query("SELECT * FROM contact WHERE id = :id")
    fun getById(id:Int): ContactwithPhones

    @Insert
    fun insertAll(vararg contacts: Contact)

   /* @Transaction
    @Insert
    fun insertAll(vararg contacts: ContactwithPhones)*/

    @Delete
    fun delete(contact: Contact)


    @Query("UPDATE contact " +
            "SET names = :names, lastName = :lastName, " +
            "imgurl = :imgurl, city = :city, age = :age, " +
            "email = :email, address = :address WHERE id = :id ")
    fun update(names:String,lastName:String, imgurl:String, city:String, age:Int,email:String,address:String, id:Int)

    @Update
    fun save(contact:Contact)

    /*@Transaction
    @Update
    fun update(contact: ContactwithPhones)*/
}