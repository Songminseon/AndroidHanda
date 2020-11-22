package com.example.handa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.handa.databinding.RankingMainBinding


class Ranking_mainFragment : Fragment() {

    override fun onCreateView(inflater:LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{

        val binding = DataBindingUtil.inflate<RankingMainBinding>(inflater,
            R.layout.ranking_main,container,false)
        return binding.root
    }

}