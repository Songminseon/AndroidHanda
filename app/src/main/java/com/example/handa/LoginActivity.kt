package com.example.handa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth





class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)

        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        findViewById<Button>(R.id.bt_signup).setOnClickListener{
            val signupIntent = Intent(this, LoginActivity::class.java)
            startActivity(signupIntent)
        }
        findViewById<Button>(R.id.bt_signin).setOnClickListener{

        }

    }




    fun register(){

    }
}