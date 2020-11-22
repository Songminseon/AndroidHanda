package com.example.handa


import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.handa.databinding.ChallengeDetailBinding


class Challenge_detailFragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ChallengeDetailBinding>(inflater,
            R.layout.challenge_detail,container,false)
        return binding.root
    }
}