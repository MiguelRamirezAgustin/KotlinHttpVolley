package com.example.httpvolley.Services

import com.example.httpvolley.Clases.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    fun getPhotos(): Call<List<DataModel>>
}