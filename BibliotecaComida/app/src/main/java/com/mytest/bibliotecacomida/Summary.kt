package com.mytest.bibliotecacomida

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.annotation.RequiresApi
import com.mytest.bibliotecacomida.modelos.Receta
import kotlinx.android.synthetic.main.activity_summary.*

class Summary : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val receta = intent.extras?.get("receta") as Receta

        lblSummary.text = Html.fromHtml(receta.summary,Html.FROM_HTML_MODE_COMPACT)

        btnWeb.setOnClickListener{
            val a = Intent(applicationContext, WebRecipe::class.java)
            a.putExtra("receta",receta)
            startActivity(a)
        }
    }
}
