package com.example.httpvolley.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.httpvolley.R

class Splash : AppCompatActivity(), Runnable {

    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        simulaCarga()
    }


    private fun simulaCarga(){
        handler = Handler()
        handler.postDelayed(this@Splash, 3000)
    }

    override fun run() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}
