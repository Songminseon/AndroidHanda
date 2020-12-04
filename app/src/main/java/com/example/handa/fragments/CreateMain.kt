package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.handa.Challenge
import com.example.handa.ChallengeAdapter
import com.example.handa.R
import kotlinx.android.synthetic.main.create_main.*
import kotlinx.android.synthetic.main.create_main.view.*


class CreateMain : Fragment() {
    var challengeList = arrayListOf<Challenge>(
            Challenge("Title", "3day", "2week", "practice"),
            Challenge("Title", "3day", "2week", "practice"),
            Challenge("Title", "3day", "2week", "practice"),
            Challenge("Title", "3day", "2week", "practice"),
            Challenge("Title", "3day", "2week", "practice"),
            Challenge("Title", "3day", "2week", "practice"),
            Challenge("Title", "3day", "2week", "practice")
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mAdapter = ChallengeAdapter(requireContext(), challengeList)
        challenge_recyclerView2.adapter = mAdapter
        val lm = GridLayoutManager(requireContext(),2)
        challenge_recyclerView2.layoutManager = lm

        view.createButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_CreateMain_to_createFirst)
        }
    }

}