package com.mytest.agendita.dao

import androidx.room.*
import com.mytest.agendita.tables.Phone

@Dao
interface PhoneDao {
    @Query("SELECT * FROM phone")
    fun getAll(): List<Phone>

    @Query("SELECT * FROM phone WHERE id IN (:phonesIds)")
    fun loadAllByIds(phonesIds: IntArray): List<Phone>

    @Query("SELECT * FROM phone WHERE contactId = :id")
    fun findByContactId(id:Int): List<Phone>

    @Query("SELECT * FROM phone WHERE id = :phone")
    fun getById(phone: Int): Phone

    @Insert
    fun insertAll(vararg phone: Phone)

    @Delete
    fun delete(phone: Phone)

    @Update
    fun update(phone: Phone)
}