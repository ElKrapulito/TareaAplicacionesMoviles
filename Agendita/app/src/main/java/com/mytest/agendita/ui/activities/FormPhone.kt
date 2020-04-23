package com.mytest.agendita.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mytest.agendita.R
import com.mytest.agendita.conn.AgendaDatabase
import com.mytest.agendita.tables.Phone
import kotlinx.android.synthetic.main.activity_form_phone.*

class FormPhone : AppCompatActivity() {
    private var id: Int = 0
    lateinit var db:AgendaDatabase
    private var phoneId:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_phone)

        db = AgendaDatabase.getInstance(this)

        loadData()
        setUpListener()

    }

    fun loadData(){
        id = intent.getIntExtra("id", 0)
        phoneId = intent.getIntExtra("phoneId",0)
        if(phoneId != 0){
            val phone = db.phoneDao().getById(phoneId)
            txtPhoneNum.setText(phone.number)
            var flag = true
            for(i in 0 until spnTypes.count){
                if(phone.type == spnTypes.getItemAtPosition(i).toString()){
                    spnTypes.setSelection(i)
                    flag = false
                    break
                }
            }
            if(flag){
                txtCustomType.setText(phone.type)
            }
        }
    }

    fun setUpListener(){
        btnSavePhone.setOnClickListener {
            var type:String
            if(!txtCustomType.text.isNullOrBlank() || !txtCustomType.text.isNullOrEmpty()){
                type = txtCustomType.text.toString()
            } else {
                type = spnTypes.selectedItem.toString()
            }
            val num = txtPhoneNum.text.toString()
            val cell:Phone
            if(phoneId == 0){
                cell = Phone(0,num,id,type)
                db.phoneDao().insertAll(cell)
            }else{
                cell = Phone(phoneId,num,id,type)
                db.phoneDao().update(cell)
            }
            finish()
        }

        btnCancelPhone.setOnClickListener {
            finish()
        }
    }
}
