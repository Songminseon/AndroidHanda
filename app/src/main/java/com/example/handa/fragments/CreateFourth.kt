package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.create_fourth.view.*

class CreateFourth : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_fourth, container, false)
    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
//        val myRef: DatabaseReference = database.getReference()
//        view.createButton4.setOnClickListener{
//            view.findNavController().navigate(R.id.action_createFourth_to_createFifth)
//        }
//    }
}