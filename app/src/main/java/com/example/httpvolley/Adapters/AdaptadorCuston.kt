package com.example.httpvolley.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.httpvolley.R
import com.example.httpvolley.Clases.Usuarios

class AdaptadorCuston(items:ArrayList<Usuarios>):RecyclerView.Adapter<AdaptadorCuston.ViewHolder>() {

    var items : ArrayList<Usuarios>? = null

    init {
            this.items= items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.items_user,parent, false)
        val viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return  items?.count()!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.nombre?.text ="Nombre: "  +item?.nombre
        holder.email?.text = item?.email

    }

    class ViewHolder(vista:View):RecyclerView.ViewHolder(vista){
        var vista = vista
        var nombre:TextView? = null
        var email:TextView? = null

        init {
            nombre = vista.findViewById(R.id.tex_nombre)
            email = vista.findViewById(R.id.tex_email)
        }

    }
}