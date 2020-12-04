package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.Cat
import com.example.handa.R
import com.example.handa.databinding.ChallengeMainBinding
import kotlinx.android.synthetic.main.challenge_main.view.*


class ChallengeMain : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.challenge_main, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.button_diet.setOnClickListener {
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)
            Cat.cat="diet"
        }
        view.button_study.setOnClickListener {
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)
            Cat.cat="study"
        }
        view.button_lang.setOnClickListener {
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)
            Cat.cat="language"

        }
        view.button_hobby.setOnClickListener {
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)
            Cat.cat="hobby"
        }
        view.button_money.setOnClickListener {
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)
            Cat.cat="money"

        }
        view.button_pattern.setOnClickListener {
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)
            Cat.cat="routine"

        }

    return binding.root
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        view.button_diet.setOnClickListener {
//            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)
//        }
    }

}
