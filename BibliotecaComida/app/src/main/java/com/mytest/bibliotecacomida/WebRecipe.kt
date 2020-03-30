package com.mytest.bibliotecacomida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.mytest.bibliotecacomida.modelos.Receta

class WebRecipe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_recipe)

        val receta = intent.extras?.get("receta") as Receta

        val myWebView: WebView = findViewById(R.id.webRecipe)
        myWebView.webViewClient = WebViewClient()
        myWebView.loadUrl(receta.url)

    }
}
