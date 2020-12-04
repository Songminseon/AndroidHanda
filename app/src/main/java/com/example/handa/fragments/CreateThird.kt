package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.R
import com.example.handa.databinding.CreateThirdBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CreateThird : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef: DatabaseReference = database.getReference()

        val binding = DataBindingUtil.inflate<CreateThirdBinding>(
            inflater,
            R.layout.create_third, container, false
        )

        binding.submitButton.setOnClickListener { view: View ->
            val title = binding.editTextTitle.text.toString()
            val category = binding.editTextCategory.text.toString()
            val description = binding.editTextDescription.text.toString()
            myRef.child("challenge").child(title).child("title").setValue(title)
            myRef.child("challenge").child(title).child("category").setValue(category)
            myRef.child("challenge").child(title).child("description").setValue(description)
            myRef.child("challenge").child(title).child("part_money").setValue("0")
            myRef.child("challenge").child(title).child("part_people").setValue("0")
            view.findNavController().navigate(R.id.action_createThird_to_CreateMain)

        }
        return binding.root
    }

}