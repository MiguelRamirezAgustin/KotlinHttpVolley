package com.example.httpvolley.Adapters

import android.icu.math.MathContext
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.httpvolley.Activitys.RetrofitGetActivity
import com.example.httpvolley.R
import com.example.httpvolley.model.ModelR
import com.example.httpvolley.response.ResponseR
import kotlinx.android.synthetic.main.item_retrofit.view.*
import kotlinx.android.synthetic.main.items_user.view.*

class RetrofitAdapter(private val context: RetrofitGetActivity, private val items:ArrayList<ModelR>):
    RecyclerView.Adapter<RetrofitAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_retrofit, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val modelo = items.get(position)
        holder.tname.text = modelo.name
        holder.username.text = modelo.username
        holder.email.text =modelo.email

    }


    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
       val tname = view.tVnameR
        val email = view.tVEmailR
        val username = view.tVUserNameR
    }
}