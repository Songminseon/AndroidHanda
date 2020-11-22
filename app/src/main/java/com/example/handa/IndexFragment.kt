package com.example.handa

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.example.handa.databinding.ActivityMainBinding
import com.example.handa.databinding.CreateMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class IndexFragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ActivityMainBinding>(inflater,
            R.layout.activity_main,container,false)

        return binding.root
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
        val fragmentTransaction =
            (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }
}