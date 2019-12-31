package com.example.httpvolley.Services

import com.example.httpvolley.Clases.DataModel
import com.example.httpvolley.Clases.DogsResponse
import com.example.httpvolley.model.ModelR
import com.example.httpvolley.response.ResponseR
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    //funcion que realiza la peticion y se le pasa como patametros url
    @GET
    fun getCharacterByName(@Url url:String):Call<DogsResponse>

    @GET("/users")
    fun getRetrofit():Call<ArrayList<ModelR>>

}