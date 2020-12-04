package com.example.handa.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.handa.Challenge
import com.example.handa.ChallengeAdapter
import com.example.handa.R
import com.google.firebase.database.*
import com.google.protobuf.NullValue
import kotlinx.android.synthetic.main.challenge_list.*
import com.example.handa.*
import com.example.handa.databinding.CreateMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.create_main.*
import kotlinx.android.synthetic.main.create_main.view.*
import org.json.JSONObject


class CreateMain : Fragment() {
    lateinit var binding: CreateMainBinding
    var total_list=arrayListOf<Challenge>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.create_main, container, false)

        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.createButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_CreateMain_to_createFirst)
        }

        val mAdapter = ChallengeAdapter(requireContext(), Cat.category_t)
        challenge_recyclerView2.adapter = mAdapter
        val lm = GridLayoutManager(requireContext(), 2)
        challenge_recyclerView2.layoutManager = lm

        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = database.getReference()

        myRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val challengeValue = snapshot?.child("challenge").children
                val challengeList = ArrayList<Challenge>()
                for (i in challengeValue){
                    val keyName:String = i.key.toString()
                    val title:String = snapshot?.child("challenge").child(keyName).child("title").value.toString()
                    val description:String = snapshot?.child("challenge").child(keyName).child("description").value.toString()
                    val part_money:String = snapshot?.child("challenge").child(keyName).child("part_money").value.toString()
                    val part_people:String = snapshot?.child("challenge").child(keyName).child("part_people").value.toString()
                    val category:String = snapshot?.child("challenge").child(keyName).child("category").value.toString()
                    challengeList.add(Challenge(title, description, category, "practice", part_money, part_people))
                }


                val mAdapter = ChallengeAdapter(requireContext(), challengeList)
                challenge_recyclerView2.adapter = mAdapter

            }

            override fun onCancelled(error: DatabaseError) {
                println("akakslak")
            }
        })
    }


}






