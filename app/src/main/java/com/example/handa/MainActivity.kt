package com.example.handa

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : AppCompatActivity() {

    //잠시 니 코드좀 지울게용
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private val navigationSelection = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when(item.itemId){
            R.id.go_challenge_main -> {
                System.out.println("1111111111")
                replaceFragment(Challenge_mainFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.go_create_main -> {
                replaceFragment(Create_mainFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.go_certify_main -> {
                replaceFragment(Certify_mainFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.go_ranking_main -> {
                replaceFragment(Ranking_mainFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.go_mypage_main -> {
                Log.d("aaaaaaaaaaaa","aaaaaaaaaaaa")
                replaceFragment(Mypage_mainFragment())
                return@OnNavigationItemSelectedListener true
            }

            else -> false
        }
    }


    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }



//    private var auth: FirebaseAuth?= null
//    private var googleSignInClient: GoogleSignInClient?= null
//    val RC_SIGN_IN = 9001
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        auth = FirebaseAuth.getInstance()
//
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build()
//
//        googleSignInClient = GoogleSignIn.getClient (this, gso)
//
//
//        findViewById<Button>(R.id.bt_login).setOnClickListener{
//            signIn()
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN && resultCode == Activity.RESULT_OK) {
//            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
//            println(result!!.status.toString())
//            if (result.isSuccess) {
//                val account = result.signInAccount
//                firebaseAuthWithGoogle(account!!)
//            } else {
//            }
//        }
//    }
//
//
//    override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth?.currentUser
//        moveMain(currentUser)
//    }
//
//    private fun signIn() {
//        val signInIntent = googleSignInClient?.signInIntent
//        startActivityForResult(signInIntent, RC_SIGN_IN)
//    }
//
//
//    private fun moveMain(user: FirebaseUser?) {
//        if (user != null) {
//            val nextIntent= Intent(this, Homemain::class.java)
//            startActivity(nextIntent)
//            finish()
//        }
//    }
//
//
//    fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
//        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
//        auth?.signInWithCredential(credential)
//            ?.addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    moveMain(auth?.currentUser)
//                }
//            }
//    }

}