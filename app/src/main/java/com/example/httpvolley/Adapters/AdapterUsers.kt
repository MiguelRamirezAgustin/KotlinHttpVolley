package com.example.httpvolley.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.httpvolley.Activitys.UserActivity
import com.example.httpvolley.Clases.ModelUsers
import com.example.httpvolley.R
import kotlinx.android.synthetic.main.item_users_volley.view.*

class AdapterUsers(private val context:UserActivity, private val userList:List<ModelUsers>):
      RecyclerView.Adapter<AdapterUsers.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_users_volley, parent, false)
       )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userModel = userList.get(position)

        holder.usu_name?.text = userModel.us_name
        holder.usu_username?.text = userModel.us_username
        holder.usu_email?.text = userModel.us_email
        holder.usu_phone?.text = userModel.us_phone
        holder.usu_web?.text = userModel.us_website
        holder.usu_street?.text = "Calle "+ userModel.us_street
        holder.usu_suite?.text = "Habitacion: "+ userModel.us_suite
        holder.usu_city?.text = "Ciudad: "+ userModel.us_city
        holder.usu_zipcode?.text = "Codigo Postal: "+ userModel.us_zipcode
        holder.usu_nameCompany?.text = "Compañía: " +userModel.us_names
        holder.usu_catchPhorase?.text = "Slogan : "+userModel.us_catchPhrase
        holder.usu_bs?.text = " - " +userModel.us_bs
        holder.usu_lat?.text = "Latitud  "+userModel.us_lat
        holder.usu_lng?.text = "Longitud  "+userModel.us_lng

        holder.verMas.setOnClickListener{
            holder.linearL.visibility = View.VISIBLE

            if (holder.linearL.visibility == View.VISIBLE){
                holder.ocultar.visibility = View.VISIBLE
                holder.verMas.visibility = View.GONE
            }
        }

        holder.ocultar.setOnClickListener {
            holder.linearL.setVisibility(View.GONE)

            if(holder.linearL.visibility ==  View.GONE){
                holder.ocultar.visibility = View.GONE
                holder.verMas.visibility = View.VISIBLE
            }
        }


    }


    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val usu_name = view.tVName
        val usu_username = view.tVUserName
        val usu_email = view.tVEmail
        val usu_phone = view.tVPhone
        val usu_web = view.tVUserWeb
        val usu_street = view.eVStreet
        val usu_suite = view.eVSuite
        val usu_city = view.eVCity
        val usu_zipcode = view.eVZipcode
        val usu_nameCompany = view.eVCompanyName
        val usu_catchPhorase = view.eVCompanyCatchP
        val usu_bs = view.eVCompanybs
        val usu_lat = view.eVLat
        val usu_lng = view.eVLog
        val verMas = view.ImgExpand
        val linearL = view.linearOcultar
        val ocultar = view.ImgOcultar

    }
}