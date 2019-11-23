package com.example.httpvolley.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.httpvolley.Adapters.AdapterUsers
import com.example.httpvolley.Clases.ModelUsers
import com.example.httpvolley.R
import com.google.gson.JsonArray
import org.json.JSONArray
import org.json.JSONObject

class UserActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null
    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var rvUsuariosRv: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        toolbar = findViewById(R.id.toolbar_getVolley_user)
        rvUsuariosRv = findViewById(R.id.rvUsuarios)

        toolbar?.setTitle("Get Volley")
        setSupportActionBar(toolbar)

        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        getUser()
    }

    private fun getUser() {
        var queus = Volley.newRequestQueue(this)
        var url: String = getString(R.string.url_user)
        var solicitud = StringRequest(
            Request.Method.GET,
            getString(R.string.url_user),
            Response.Listener<String> { response ->

                if (response != null) {
                    // Log.d("RespuestaUser ", response)
                }
                try {
                    //Log.d("SolicitudVolly ", response)
                    val listaUsers = ArrayList<ModelUsers>()

                    val usuarioArray = JSONArray(response)
                    for (i in 0 until usuarioArray.length()) {
                        val sObject = usuarioArray.get(i).toString()
                        val mItemObject = JSONObject(sObject)
                        Log.d("For_Resul ", mItemObject.toString())

                        val us_id = mItemObject.getString("id")
                        val us_name = mItemObject.getString("name")
                        val us_username = mItemObject.getString("username")
                        val us_email = mItemObject.getString("email")
                        val us_phone = mItemObject.getString("phone")
                        val us_web = mItemObject.getString("website")


                        //Obtener valor de JSONObjeto address
                        val jsonObjetAddress = JSONObject(mItemObject.getString("address"))
                        Log.d("For_Resul_objet ", jsonObjetAddress.toString())

                        val us_street = jsonObjetAddress.getString("street")
                        val us_suite = jsonObjetAddress.getString("suite")
                        val us_city = jsonObjetAddress.getString("city")
                        val us_zipcode = jsonObjetAddress.getString("zipcode")

                        //Obtener valores de JSONObjeto geo
                        val jsonObjectGeo = JSONObject(jsonObjetAddress.getString("geo"))

                        val us_lat = jsonObjectGeo.getString("lat")
                        val us_lng = jsonObjectGeo.getString("lng")


                        //Obtener valores de JSONObjet company
                        val jsonObjectCompany = JSONObject(mItemObject.getString("company"))

                        val us_nameC = jsonObjectCompany.getString("name")
                        val us_catchPhrase = jsonObjectCompany.getString("catchPhrase")
                        val us_bs = jsonObjectCompany.getString("bs")


                        val objeto = ModelUsers(
                            us_id, us_name, us_username, us_email, "", us_street, us_suite,
                            us_city, us_zipcode, "", us_lat, us_lng, us_phone, us_web, "",
                            us_nameC, us_catchPhrase, us_bs)
                        listaUsers.add(objeto)

                    }

                    //Mostrar datos en pantalla
                    linearLayoutManager = LinearLayoutManager(this)
                    val rvUsuario = findViewById<RecyclerView>(R.id.rvUsuarios)
                    rvUsuario!!.addItemDecoration(
                        DividerItemDecoration(
                            applicationContext,
                            LinearLayoutManager.VERTICAL
                        )
                    )
                    rvUsuario.layoutManager = linearLayoutManager
                    rvUsuario.adapter = AdapterUsers(this, listaUsers)

                } catch (E: Exception) {
                    Toast.makeText(
                        this,
                        "Ocurrio un error ",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            Response.ErrorListener {
                Toast.makeText(
                    this@UserActivity,
                    "Intente nuevamente",
                    Toast.LENGTH_SHORT
                ).show()
            })
        queus.add(solicitud)
    }
}

//Array que se consume
/*[
{
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
    "street": "Kulas Light",
    "suite": "Apt. 556",
    "city": "Gwenborough",
    "zipcode": "92998-3874",
    "geo": {
    "lat": "-37.3159",
    "lng": "81.1496"
}
},
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
    "name": "Romaguera-Crona",
    "catchPhrase": "Multi-layered client-server neural-net",
    "bs": "harness real-time e-markets"
}
}
]*/