package com.example.handa

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth




class LoginActivity : AppCompatActivity(){

    private var auth: FirebaseAuth? = null
    private val TAG : String = "Login"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)
        auth = FirebaseAuth.getInstance()

        val email=findViewById<EditText>(R.id.si_email)
        val pd=findViewById<EditText>(R.id.si_pd)


        findViewById<Button>(R.id.bt_signin).setOnClickListener {
            if (email.text.toString().isEmpty() || pd.text.toString().isEmpty()) {
                Toast.makeText(this, "email 혹은 password를 반드시 입력하세요.", Toast.LENGTH_SHORT).show()
            } else {
                auth!!.signInWithEmailAndPassword(email.text.toString(), pd.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success")
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                    }
            }
        }

        findViewById<Button>(R.id.bt_signup).setOnClickListener {
            val intent2 = Intent(this, RegisterActivity::class.java)
            startActivity(intent2)
        }
    }
}