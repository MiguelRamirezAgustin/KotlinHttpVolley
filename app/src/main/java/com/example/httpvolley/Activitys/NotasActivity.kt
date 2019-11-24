package com.example.httpvolley.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.httpvolley.R
import org.jetbrains.anko.alert

class NotasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)

        getNotas("https://api.datos.gob.mx/v1/dgm.estadisticas")
    }

    private fun getNotas(url: String) {
        var queue = Volley.newRequestQueue(this)
        val solicitud =
            StringRequest(Request.Method.GET, url, Response.Listener<String> {
                response ->
                try {

                    Log.d("ResponseNotas ", response)

                } catch (E: Exception) {
                    alert {
                        "Ocurrio un error " + E
                        yesButton { }
                    }.show()
                }
            }, Response.ErrorListener {
                alert {
                    "Ocurrio un error al realizar la peticion"
                    yesButton { }
                }.show()
            })
        queue.add(solicitud)
    }
}
