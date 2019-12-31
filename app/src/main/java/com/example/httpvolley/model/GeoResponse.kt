package com.example.httpvolley.model

import com.google.gson.annotations.SerializedName

class GeoResponse (@SerializedName("lat")val lat:String,
                   @SerializedName("lng")val lng:String)