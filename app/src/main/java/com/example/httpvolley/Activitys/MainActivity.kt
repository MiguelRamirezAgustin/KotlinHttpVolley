package com.example.httpvolley.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import androidx.appcompat.widget.Toolbar
import com.example.httpvolley.*
import com.example.httpvolley.Adapters.AdaptadorCuston
import com.example.httpvolley.Clases.Usuarios
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    var lista: RecyclerView? = null
    var adaptador: AdaptadorCuston? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var dataName:String? = null
    var dataEmail:String? = null
    var usuarios = ArrayList<Usuarios>()
    var toolbar_: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar_ = findViewById(R.id.toolbar_main)
        lista = findViewById(R.id.lista)
        lista?.setHasFixedSize(true)

        toolbar_?.setTitle("Consumo de Api Volley")
        setSupportActionBar(toolbar_)

        layoutManager = LinearLayoutManager(this)
        lista?.layoutManager = layoutManager




        RequesVolley()

    }



    fun RequesVolley() {
       // Toast.makeText(this, "Evento", Toast.LENGTH_SHORT).show()
        val queue = Volley.newRequestQueue(this)
        val url: String =
            "https://gist.githubusercontent.com/MiguelRamirezAgustin/270e75be63b5cbdb5faf88c72839b26d/raw/93516f8944283ed0ed7be1faa8e5888295b3f271/apiPruebas"

        val stringReq = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->

                var strResp = response.toString()
                val jsonObj: JSONObject = JSONObject(strResp)
                var jsonArray: JSONArray = jsonObj.getJSONArray("employees")
                for (i in 0 until jsonArray.length()) {
                    var jsonInner: JSONObject = jsonArray.getJSONObject(i)
                    dataName = jsonInner.get("name").toString()
                    dataEmail = jsonInner.get("email").toString()
                    usuarios.add(Usuarios(dataName.toString(), dataEmail.toString() ))

                }
                adaptador = AdaptadorCuston(usuarios)
                lista?.adapter = adaptador
            }, Response.ErrorListener {
                Log.d("TAG", "Error>>>>>>>>>>>>>>>>>>> ")
            })
        queue.add(stringReq)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.id_retrofit ->{
                val intent = Intent(this, GetRetrofitdog::class.java)
                startActivity(intent)
                return true
            }
            R.id.id_retrofitUser ->{
                val intent = Intent(this, GetRetrofitUser::class.java)
                startActivity(intent)
                return true
            }
            R.id.id_getVolley -> {
                val itent = Intent(this, GetVolleyComments::class.java)
                startActivity(itent)
                return true
            }
            R.id.id_getVolleyUser ->{
                startActivity(Intent(this, UserActivity::class.java))
                return true
            }else ->{
            return super.onOptionsItemSelected(item)
           }
        }
    }






}
