package com.mytest.minipaint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_linea.setOnClickListener{
            lienzito.dbLinea = true
            lienzito.dbCirculo = false
            lienzito.dbCuadrado = false
        }

        btn_cuadrado.setOnClickListener {
            lienzito.dbLinea = false
            lienzito.dbCirculo = false
            lienzito.dbCuadrado = true
        }

        btn_circulo.setOnClickListener {
            lienzito.dbLinea = false
            lienzito.dbCirculo = true
            lienzito.dbCuadrado = false
        }
    }


}
