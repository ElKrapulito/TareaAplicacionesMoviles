package com.mytest.agendita.tables

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity()
data class Contact(
    @PrimaryKey(autoGenerate = true) var id:Int,
    var names:String?,
    var lastname:String?,
    var imgUrl:String?,
    var city:String?,
    var age:Int?,
    var email:String?,
    var address:String?
)
{
    constructor():this(0,"","","","",0,"","")
}
