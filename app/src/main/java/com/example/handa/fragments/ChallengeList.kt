package com.example.handa.fragments


import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.renderscript.Sampler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handa.Challenge
import com.example.handa.ChallengeAdapter
import com.example.handa.Post
import com.example.handa.R
import com.example.handa.databinding.ChallengeListBinding
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.challenge_list.*
import kotlinx.android.synthetic.main.create_sixth.*
import org.json.JSONObject


class ChallengeList: Fragment(){
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<ChallengeListBinding>(inflater,
       R.layout.challenge_list, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lm = GridLayoutManager(requireContext(), 2)
        challenge_recyclerView1.layoutManager = lm

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
                challenge_recyclerView1.adapter = mAdapter

            }

            override fun onCancelled(error: DatabaseError) {
                println("akakslak")
            }
        })


    }
}