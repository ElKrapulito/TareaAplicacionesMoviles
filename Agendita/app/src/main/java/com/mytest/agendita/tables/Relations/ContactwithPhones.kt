package com.mytest.agendita.tables.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.mytest.agendita.tables.Contact
import com.mytest.agendita.tables.Phone

data class ContactwithPhones (
    @Embedded val contact: Contact,
    @Relation(
        parentColumn = "id",
        entityColumn = "contactId"
    )
    val phones:List<Phone>
)
