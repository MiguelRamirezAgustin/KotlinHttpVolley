package com.example.httpvolley.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.httpvolley.Clases.DataModel
import com.example.httpvolley.R
import kotlinx.android.synthetic.main.item_user.view.*

class DataAdapter(private var dataList: List<DataModel>, private val context: Context) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel=dataList.get(position)

        holder.titleTextView.text= "Titulo: " +dataModel.title
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var titleTextView:TextView
        init {
            titleTextView=view.findViewById(R.id.title_users)

        }
    }


}