package com.example.httpvolley.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.httpvolley.Adapters.RetrofitAdapter
import com.example.httpvolley.R
import com.example.httpvolley.Services.APIService
import com.example.httpvolley.model.ModelR
import com.example.httpvolley.response.ResponseR
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGetActivity : AppCompatActivity() {

    var toolbar : Toolbar? = null
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_get)

        supportActionBar?.hide()

        toolbar = findViewById(R.id.toolbar_retrofit)


        toolbar?.setTitle("Consumo de api Retorfit")
        setSupportActionBar(toolbar)

        var actionBar= supportActionBar
        actionBar?.setDisplayShowHomeEnabled(true)
        getRetrofits()
    }

    fun getRetrofits(){
        doAsync {
            val call = retrofit().create(APIService::class.java).getRetrofit().execute()
            val response = call.body() as ArrayList<ModelR>
            Log.d("TAG", "Response "+response[0].name)
            uiThread {
                linearLayoutManager = LinearLayoutManager(this@RetrofitGetActivity)
                val rvUser = findViewById<RecyclerView>(R.id.recycler_userR)
                rvUser.layoutManager = linearLayoutManager
                rvUser.adapter = RetrofitAdapter(this@RetrofitGetActivity, response)
            }
        }
    }

    private fun retrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
