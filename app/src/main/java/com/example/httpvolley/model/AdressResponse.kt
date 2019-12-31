package com.example.httpvolley.model

import com.google.gson.annotations.SerializedName

class AdressResponse (@SerializedName("street")val street:String,
                      @SerializedName("suite")val suite:String,
                      @SerializedName("city")val city:String,
                      @SerializedName("zipcode")val zipcode:String,
                      @SerializedName("geo")val geo:GeoResponse)