package com.example.httpvolley.Activitys

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.httpvolley.Adapters.DataAdapter
import com.example.httpvolley.Clases.DataModel
import com.example.httpvolley.R
import com.example.httpvolley.Services.ApiClient
import org.jetbrains.anko.alert
import retrofit2.Call
import retrofit2.Response

class GetRetrofitUser : AppCompatActivity() {

    var toolbar : Toolbar? = null
    lateinit var progreesDialog: ProgressDialog
    var dataList=ArrayList<DataModel>()
    lateinit var adapter:DataAdapter
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_retrofit_user)


        toolbar= findViewById(R.id.toolbar_retrofit_user)
        recyclerView= findViewById(R.id.recycler_user)


        toolbar?.setTitle("Retrofit User")
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)


        recyclerView.adapter= DataAdapter(dataList, this)
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)

        progreesDialog=ProgressDialog(this)
        progreesDialog.setTitle("Cargando.....")
        progreesDialog.setCancelable(false)
        progreesDialog.show()
        getData()
    }


  private fun  getData() {
      val call: Call<List<DataModel>> = ApiClient.getClient.getPhotos()
      call.enqueue(object : retrofit2.Callback<List<DataModel>> {

          override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
              progreesDialog.dismiss()
              Log.d("respuesta---- ", response.toString())

              dataList.addAll(response!!.body()!!)
              recyclerView.adapter?.notifyDataSetChanged()
          }

          override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
              progreesDialog.dismiss()
          }
      })
  }


}
