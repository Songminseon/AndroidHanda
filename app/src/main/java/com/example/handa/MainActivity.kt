package com.example.handa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView

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

}