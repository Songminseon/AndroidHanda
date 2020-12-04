package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.R
import com.example.handa.databinding.ChallengeMainBinding
import kotlinx.android.synthetic.main.challenge_main.view.*


class ChallengeMain : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<ChallengeMainBinding>(inflater,
        R.layout.challenge_main, container, false)

        binding.buttonDiet.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_ChallengeMain_to_challengeList)
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
