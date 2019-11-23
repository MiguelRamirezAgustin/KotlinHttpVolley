package com.example.httpvolley.Clases

import com.google.gson.annotations.SerializedName

class DataModel (

    @SerializedName("albumId")
    var albumId: kotlin.Int,
    @SerializedName("id")
    var id: kotlin.Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: kotlin.String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
)