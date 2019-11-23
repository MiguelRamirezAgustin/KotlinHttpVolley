package com.example.httpvolley.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.httpvolley.Services.APIService
import com.example.httpvolley.Adapters.DogsAdapter
import com.example.httpvolley.Clases.DogsResponse
import com.example.httpvolley.R
import kotlinx.android.synthetic.main.activity_get_retrofitdog.*
import org.jetbrains.anko.alert
import retrofit2.Retrofit
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.converter.gson.GsonConverterFactory

class GetRetrofitdog : AppCompatActivity(), SearchView.OnQueryTextListener {

    var toolbar : Toolbar? = null

    lateinit var imagesPuppies:List<String>
    lateinit var dogsAdapter: DogsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_retrofitdog)
        searchBreed.setOnQueryTextListener(this)

        toolbar = findViewById(R.id.toolbar_retrofit)


        toolbar?.setTitle("Consumo de api Retorfit")
        setSupportActionBar(toolbar)

        //activar boton de back
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }


    private fun initCharacter(puppies: DogsResponse) {
        if(puppies.status == "success"){
            imagesPuppies = puppies.images
        }
        dogsAdapter = DogsAdapter(imagesPuppies)
        recycler_dog.setHasFixedSize(true)
        recycler_dog.layoutManager = LinearLayoutManager(this)
        recycler_dog.adapter = dogsAdapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    override fun onQueryTextSubmit(query: String): Boolean {
        searchByName(query.toLowerCase())
        return true
    }

    private fun searchByName(query: String) {
        doAsync {
            //consumi de api y ver las razas de perros https://dog.ceo/dog-api/breeds-list
            val call = getRetrofit().create(APIService::class.java).getCharacterByName("$query/images").execute()
            val puppies = call.body() as DogsResponse
            uiThread {
                if(puppies.status == "success") {
                    initCharacter(puppies)
                }else{
                    showErrorDialog()
                }
                hideKeyboard()
            }
        }
    }

    private fun showErrorDialog() {
        alert("Ha ocurrido un error, inténtelo de nuevo.") {
            yesButton { }
        }.show()
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    private fun hideKeyboard(){
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(linera_layout.windowToken, 0)
    }


}
