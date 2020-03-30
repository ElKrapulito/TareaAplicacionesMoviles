package com.mytest.bibliotecacomida.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mytest.bibliotecacomida.R
import com.mytest.bibliotecacomida.modelos.Receta
import com.squareup.picasso.Picasso


/*Ejemplo https://api.spoonacular.com/recipes/485365/information?apiKey=f893c42fece24b2eb9861212f1202c45
request de infomacion de recetas
Ejemplp https://spoonacular.com/recipeImages/215435-556x370.jpg
request de imagen
*/


class ItemArrayAdapter(context: Context, resource: Int, objects: Array<out Receta>) :
    ArrayAdapter<Receta>(context, resource, objects) {

    /*
    * ImageView imageView = findViewById(R.id.imageView2);
        String imageUrl = "https://via.placeholder.com/500";

        //Loading image using Picasso
        Picasso.get().load(imageUrl).into(imageView);
    *
    *
    * */

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val contenedor = inflater.inflate(R.layout.lista_recetas, parent,false)
        val receta = getItem(position) ?: return super.getView(position, convertView, parent)
        val lblNombre = contenedor.findViewById<TextView>(R.id.lblRecipeName)
        val imgRecipe = contenedor.findViewById<ImageView>(R.id.imgRecipe)

        val imageUrl = receta.image
        lblNombre.text = receta.title

        //Loading image using Picasso
        Picasso.get().load(imageUrl).into(imgRecipe)

        return contenedor
    }
}

