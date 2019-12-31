package com.example.httpvolley.model

import com.google.gson.annotations.SerializedName

class CompanyResponse (@SerializedName("name")val name:String,
                       @SerializedName("catchPhrase")val catchPhrase:String,
                       @SerializedName("bs")val bs:String)