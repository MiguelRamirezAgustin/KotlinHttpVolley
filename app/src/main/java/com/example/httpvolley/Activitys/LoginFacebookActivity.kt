package com.example.httpvolley.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.CallbackManager
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.FacebookCallback
import com.facebook.login.widget.LoginButton
import android.content.Intent
import android.util.Log
import com.facebook.AccessToken


class LoginFacebookActivity : AppCompatActivity() {

    private  var callbackManager:CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.httpvolley.R.layout.activity_login_facebook)

        callbackManager = CallbackManager.Factory.create()

        val loginButton = findViewById<LoginButton>(com.example.httpvolley.R.id.login_button)
        loginButton.setReadPermissions("email")
        // If using in a fragment
        //loginButton.setFragment(this)

        // Callback registration
        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                // App code solicitud exitosa

                val accessToken = AccessToken.getCurrentAccessToken()
                val isLoggedIn = accessToken != null && !accessToken.isExpired

                Log.d("ACCES_TOKEN", accessToken.token)

            }

            override fun onCancel() {
                // App code solicitud cancelada
            }

            override fun onError(exception: FacebookException) {
                // App code solicitud error
            }
        })
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager?.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}
