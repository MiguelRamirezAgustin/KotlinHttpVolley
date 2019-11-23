package com.example.httpvolley.Clases

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ModelUsers (@SerializedName("id") @Expose val us_id:String,
                  @SerializedName("name")@Expose val us_name:String,
                  @SerializedName("username")@Expose val us_username:String,
                  @SerializedName("email")@Expose val us_email:String,
                  @SerializedName("adress")@Expose val us_adress:String,
                  @SerializedName("street")@Expose val us_street:String,
                  @SerializedName("suite")@Expose val us_suite:String,
                  @SerializedName("city")@Expose val us_city:String,
                  @SerializedName("zipcode")@Expose val us_zipcode:String,
                  @SerializedName("geo")@Expose val us_geo:String,
                  @SerializedName("lat")@Expose val us_lat:String,
                  @SerializedName("lng")@Expose val us_lng:String,
                  @SerializedName("phone")@Expose val us_phone:String,
                  @SerializedName("website")@Expose val us_website:String,
                  @SerializedName("company")@Expose val us_company:String,
                  @SerializedName("name")@Expose val us_names:String,
                  @SerializedName("catchPhrase")@Expose val us_catchPhrase:String,
                  @SerializedName("bs")@Expose val us_bs:String
)