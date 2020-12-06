package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.`object`.Cat
import com.example.handa.R
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
            Cat.cat="diet"
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)
        }
        view.button_study.setOnClickListener {
            Cat.cat="study"
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)
        }
        view.button_lang.setOnClickListener {
            Cat.cat="language"
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)

        }
        view.button_hobby.setOnClickListener {
            Cat.cat="hobby"
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)
        }
        view.button_money.setOnClickListener {
            Cat.cat="money"
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)

        }
        view.button_pattern.setOnClickListener {
            Cat.cat="lifestyle"
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)

        }

    }

}
