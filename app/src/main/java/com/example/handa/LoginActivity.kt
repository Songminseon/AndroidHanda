package com.example.handa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class LoginActivity : AppCompatActivity(){

    private val TAG : String = "Login"
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var mStorageRef: StorageReference? = null
    var imageURL: Uri? = null
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)
        auth = FirebaseAuth.getInstance()

        val email=findViewById<EditText>(R.id.si_email)
        val pd=findViewById<EditText>(R.id.si_pd)


        findViewById<Button>(R.id.bt_signin).setOnClickListener {
            mStorageRef = FirebaseStorage.getInstance().reference
            val user = auth.currentUser

            val data = database.getReference("challenge")
            val data_c=database.getReference("certify")


            data.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (ch in snapshot.children) {
                        if (ch.child("category").value.toString() == "diet") {
                            val image = ch.child("image").value.toString()
                            val mountainRef = mStorageRef!!.child("publicDiet/$image").downloadUrl
                                .addOnSuccessListener { imageURL = it }
                                .addOnFailureListener {}
                            Cat.category_d.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                            Cat.category_t.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                        }
                        if (ch.child("category").value.toString() == "study") {
                            val image = ch.child("image").value.toString()
                            val mountainRef = mStorageRef!!.child("publicStudy/$image").downloadUrl
                                .addOnSuccessListener { imageURL = it }
                                .addOnFailureListener {}
                            Cat.category_s.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                            Cat.category_t.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                        }
                        if (ch.child("category").value.toString() == "hobby") {
                            val image = ch.child("image").value.toString()
                            val mountainRef = mStorageRef!!.child("publicHobby/$image").downloadUrl
                                .addOnSuccessListener { imageURL = it }
                                .addOnFailureListener {}
                            Cat.category_h.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                            Cat.category_t.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                        }
                        if (ch.child("category").value.toString() == "money") {
                            val image = ch.child("image").value.toString()
                            val mountainRef = mStorageRef!!.child("publicMoney/$image").downloadUrl
                                .addOnSuccessListener { imageURL = it }
                                .addOnFailureListener {}
                            Cat.category_m.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                            Cat.category_t.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                        }
                        if (ch.child("category").value.toString() == "language") {
                            val image = ch.child("image").value.toString()
                            val mountainRef = mStorageRef!!.child("publicLanguage/$image").downloadUrl
                                .addOnSuccessListener { imageURL = it }
                                .addOnFailureListener {}
                            Cat.category_l.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                            Cat.category_t.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                        }
                        if (ch.child("category").value.toString() == "routine") {
                            val image = ch.child("image").value.toString()
                            val mountainRef = mStorageRef!!.child("publicDaily/$image").downloadUrl
                                .addOnSuccessListener { imageURL = it }
                                .addOnFailureListener {}
                            Cat.category_r.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                            Cat.category_t.add(
                                Challenge(
                                    ch.child("category").value.toString(),
                                    ch.child("title").value.toString(),
                                    ch.child("remain").value.toString(),
                                    ch.child("term").value.toString(),
                                    imageURL
                                )
                            )
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

            data_c.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (ch in snapshot.children){
                        if(user!!.uid.toString()==ch.value.toString()){
                            for(li in ch.children){
                                val image = li.child("img_uri").value.toString()
                                val mountainRef = mStorageRef!!.child("publicDiet/$image").downloadUrl
                                    .addOnSuccessListener { imageURL = it }
                                    .addOnFailureListener {}
                                Cer.user_list.add(
                                    Certify(
                                        li.child("title").value.toString(),
                                        li.child("remain").value.toString(),
                                        li.child("rate").value.toString().toDouble(),
                                        imageURL
                                    )
                                )
                            }
                        }
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                }

            })

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