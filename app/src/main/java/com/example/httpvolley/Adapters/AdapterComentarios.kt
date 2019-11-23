package com.example.httpvolley.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.httpvolley.Activitys.GetVolleyComments
import com.example.httpvolley.Clases.DataCommentsModel
import com.example.httpvolley.R
import kotlinx.android.synthetic.main.item_volleyget_coment.view.*

class AdapterComentarios(private val context: GetVolleyComments, private val comentariosList:ArrayList<DataCommentsModel>):
    RecyclerView.Adapter<AdapterComentarios.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_volleyget_coment, parent, false))
    }

    override fun getItemCount(): Int {
        return comentariosList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comentariModel = comentariosList.get(position)
        holder.comName?.text = "Nombre: " +comentariModel.name_com
        holder.comEmail?.text = "Correo "+ comentariModel.email_com
    }


    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val comName = view.txt_name
        val comEmail = view.txt_email
    }

}