package com.example.handa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {

    //잠시 니 코드좀 지울게용

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        when (item.itemId) {
            R.id.go_challenge_main -> {
                val fragmentA = Challenge_mainFragment()
                transaction.replace(R.id.fragment_container, fragmentA)
                transaction.commit()
                return true
            }

            R.id.go_create_main -> {
                val fragmentB = Create_mainFragment()
                transaction.replace(R.id.fragment_container, fragmentB)
                transaction.commit()
                return true
            }

            R.id.go_certify_main -> {
                val fragmentC = Certify_mainFragment()
                transaction.replace(R.id.fragment_container, fragmentC)
                transaction.commit()
                return true
            }

            R.id.go_ranking_main -> {
                val fragmentD = Ranking_mainFragment()
                transaction.replace(R.id.fragment_container, fragmentD)
                transaction.commit()
                return true
            }

            R.id.go_mypage_main -> {
                val fragmentE = Mypage_mainFragment()
                transaction.replace(R.id.fragment_container, fragmentE)
                transaction.commit()
                return true
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentA = Challenge_mainFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragmentA).commitAllowingStateLoss();
        val nav=findViewById<BottomNavigationView>(R.id.bottom_navigation)
        nav.setOnNavigationItemSelectedListener(this)

    }
}