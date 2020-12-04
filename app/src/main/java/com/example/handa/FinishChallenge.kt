package com.example.handa


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager


import com.example.handa.R
import kotlinx.android.synthetic.main.finish_challenge.*
class FinishChallenge : AppCompatActivity() {
    var finishlist = arrayListOf<Finish>(
        Finish("practice", "Happay"),
        Finish("practice", "Happay"),
        Finish("practice", "Happay"),
        Finish("practice", "Happay"),
        Finish("practice", "Happay"),
        Finish("practice", "Happay"),
        Finish("practice", "Happay")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.finish_challenge)
        val mAdapter = FinishAdapter(this, finishlist)
        f_list.adapter = mAdapter
        val lm = GridLayoutManager(this,3)
        f_list.layoutManager = lm

    }
}