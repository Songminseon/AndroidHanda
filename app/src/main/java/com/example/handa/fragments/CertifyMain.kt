package com.example.handa.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.handa.Challenge
import com.example.handa.ChallengeAdapter
import com.example.handa.R
import com.example.handa.databinding.CertifyMainBinding
import kotlinx.android.synthetic.main.challenge_list.*


class CertifyMain : Fragment() {



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<CertifyMainBinding>(inflater,
        R.layout.certify_main, container, false)


    return binding.root
    }
}