package com.example.handa



import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.GridLayoutManager
import com.example.handa.`object`.Finish
import com.example.handa.adapter.FinishAdapter


import kotlinx.android.synthetic.main.finish_challenge.*



class FinishChallenge : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.finish_challenge)
        val mAdapter = FinishAdapter(this, Finish.finish_list)
        f_list.adapter = mAdapter
        val lm = GridLayoutManager(this,2)
        f_list.layoutManager = lm
        f_button.setOnClickListener{
            val intent = Intent(this, FinishChallengeSecond::class.java)
            startActivity(intent)
            finish()
        }
    }
}