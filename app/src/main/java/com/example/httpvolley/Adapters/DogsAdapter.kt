package com.example.httpvolley.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.httpvolley.R
import com.example.httpvolley.fromUrl
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsAdapter(var images:List<String>):RecyclerView.Adapter<DogsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_dog, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return  images.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = images[position]
        holder.bin(item)
    }


    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        fun bin(image:String){
            itemView.ivDog.fromUrl(image)
        }
    }

}