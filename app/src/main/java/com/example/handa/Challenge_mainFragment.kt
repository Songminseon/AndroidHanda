package com.example.handa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.databinding.ChallengeMainBinding


class Challenge_mainFragment : Fragment() {

    override fun onCreateView(inflater:LayoutInflater, container: ViewGroup?,
                              savedInstanceState:Bundle?): View? {

        val binding = DataBindingUtil.inflate<ChallengeMainBinding>(inflater,
            R.layout.challenge_main,container,false)
        
        binding.buttonDiet.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_ChallengeMainFragment_to_challenge_detailFragment)
        }
        return binding.root
    }

}
