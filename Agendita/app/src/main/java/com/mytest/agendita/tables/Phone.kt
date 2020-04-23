package com.mytest.agendita.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Phone(
    @PrimaryKey(autoGenerate = true) var id:Int,
    var number:String?,
    var contactId:Int?,
    var type:String?
)