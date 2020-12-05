package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.R
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.create_first.view.*

class CreateFirst : Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.create_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.createFirst.setOnClickListener {
            view.findNavController().navigate(R.id.action_createFirst_to_createSecond)
        }

    }


}
