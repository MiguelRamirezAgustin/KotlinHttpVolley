package com.example.httpvolley.Clases

import com.example.httpvolley.Activitys.GetVolleyComments
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataCommentsModel(@SerializedName("postId")@Expose val postId_com:String?,
                        @SerializedName("id")@Expose val Id_com:String?,
                        @SerializedName("name")@Expose val name_com:String?,
                        @SerializedName("email")@Expose val email_com:String?,
                        @SerializedName("body")@Expose val body_com:String?
                   )