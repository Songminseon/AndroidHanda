package com.example.handa.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.handa.R
import com.example.handa.databinding.ChallengeDetailBinding


class ChallengeDetail: Fragment(){

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