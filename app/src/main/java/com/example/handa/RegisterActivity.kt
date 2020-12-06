package com.example.handa

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.handa.dataclass.Post
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class RegisterActivity: AppCompatActivity(){

    private lateinit var auth: FirebaseAuth
    private val TAG : String = "CreateAccount"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        val database: FirebaseDatabase = FirebaseDatabase.getInstance()

        auth=FirebaseAuth.getInstance()


        val email=findViewById<EditText>(R.id.su_email)
        val pd=findViewById<EditText>(R.id.su_pd)
        val name=findViewById<EditText>(R.id.user_name)

        findViewById<Button>(R.id.bt_Resister).setOnClickListener{
            val DatabaseReference = database.reference

            if (email.text.toString().isEmpty() || pd.text.toString().isEmpty()){
                Toast.makeText(this, "email 혹은 password를 반드시 입력하세요.", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email.text.toString(), pd.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success")
                            val user = auth.currentUser
                            val data = Post(name.text.toString(),point=0,money=0)
                            val info = data.toMap()
                            DatabaseReference.child("userDB").child(user?.uid.toString()).setValue(info)
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                            //updateUI(null)
                            //입력필드 초기화
                            email?.setText("")
                            pd?.setText("")
                            email.requestFocus()
                        }
                    }
            }
        }
    }
    }