package com.example.handa.fragments



import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import android.net.Uri
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

import com.example.handa.*

import com.google.firebase.database.FirebaseDatabase

import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.challenge_list.*



class ChallengeList: Fragment(){
    lateinit var binding:ChallengeListBinding
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var mStorageRef: StorageReference? = null
    var imageURL: Uri?=null
    lateinit var mAdapter:ChallengeAdapter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(inflater, R.layout.challenge_list, container, false)
        binding.cat= Category(Cat.cat)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when(Cat.cat){
            "diet" -> mAdapter = ChallengeAdapter(requireContext(),Cat.category_d)
            "study" -> mAdapter = ChallengeAdapter(requireContext(),Cat.category_s)
            "hobby" -> mAdapter = ChallengeAdapter(requireContext(),Cat.category_h)
            "money" -> mAdapter = ChallengeAdapter(requireContext(),Cat.category_m)
            "language" -> mAdapter = ChallengeAdapter(requireContext(),Cat.category_l)
            "routine" -> mAdapter = ChallengeAdapter(requireContext(),Cat.category_r)
        }
        challenge_recyclerView1.adapter = mAdapter
        val lm = GridLayoutManager(requireContext(), 2)
        challenge_recyclerView1.layoutManager = lm
    }
}