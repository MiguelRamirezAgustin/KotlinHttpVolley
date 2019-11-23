package com.example.httpvolley.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.httpvolley.Adapters.AdapterComentarios
import com.example.httpvolley.Clases.DataCommentsModel
import com.example.httpvolley.R
import org.jetbrains.anko.alert
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class GetVolleyComments : AppCompatActivity() {

    var toolbar:Toolbar? = null
    var dataList =ArrayList<DataCommentsModel>()
    var dataName:String? = null

    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var rvComentario: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_volley_comments)

        toolbar= findViewById(R.id.toolbar_getVolley)
        rvComentario= findViewById(R.id.recycler_get_Volley_comment)

        toolbar?.setTitle("Get Volley")
        setSupportActionBar(toolbar)

        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        getData("https://jsonplaceholder.typicode.com/comments")

    }


    private fun getData(url:String){
        var queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String> {
            response ->
            try {
                    Log.d( "Respuest volley get ", response)
                val listaComentarios = ArrayList<DataCommentsModel>()

                val responseArray = JSONArray(response)

                for (i in 0 until responseArray.length()){
                    val sObject = responseArray.get(i).toString()

                    val mItemObket = JSONObject(sObject)

                    val comm_postId= mItemObket.getString("postId")
                    val comm_id= mItemObket.getString("id")
                    val comm_name= mItemObket.getString("name")
                    val comm_email= mItemObket.getString("email")
                    val comm_body= mItemObket.getString("body")
                    val objeto = DataCommentsModel(comm_postId, comm_id, comm_name, comm_email, comm_body)
                    listaComentarios.add(objeto)

                }

                linearLayoutManager = LinearLayoutManager(this)
                val rvComentarios = findViewById<RecyclerView>(R.id.recycler_get_Volley_comment)
                rvComentarios!!.addItemDecoration(
                    DividerItemDecoration(
                        applicationContext,
                        LinearLayoutManager.VERTICAL
                    )
                )
                rvComentarios.layoutManager = linearLayoutManager
                rvComentarios.adapter = AdapterComentarios(this, listaComentarios)

            }catch (E:Exception){
                alert { "Ocurrio un error " + E
                  yesButton {  }
                }.show()
            }
        }, Response.ErrorListener {
            alert { "Ocurrio un error al realizar la peticion"
              yesButton {  }
            }.show()
        })
        queue.add(solicitud)
    }


}

/*var strResp = response.toString()
val jsonObj: JSONObject = JSONObject(strResp)
var jsonArray: JSONArray = jsonObj.getJSONArray("employees")
for (i in 0 until jsonArray.length()) {
    var jsonInner: JSONObject = jsonArray.getJSONObject(i)
    dataName = jsonInner.get("name").toString()
    dataEmail = jsonInner.get("email").toString()
    usuarios.add(Usuarios(dataName.toString(), dataEmail.toString() ))

}*/