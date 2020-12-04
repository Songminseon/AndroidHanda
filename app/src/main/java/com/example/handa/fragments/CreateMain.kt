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


class CreateMain : Fragment() {
    lateinit var binding: CreateMainBinding
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var mStorageRef: StorageReference? = null
    var total_list=arrayListOf<Challenge>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        total_list.addAll(Cat.category_s)
        total_list.addAll(Cat.category_d)
        total_list.addAll(Cat.category_h)
        total_list.addAll(Cat.category_m)
        total_list.addAll(Cat.category_l)
        total_list.addAll(Cat.category_r)
        binding= DataBindingUtil.inflate(inflater, R.layout.create_main, container, false)
        mStorageRef = FirebaseStorage.getInstance().reference
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = ChallengeAdapter(requireContext(), total_list)
        challenge_recyclerView2.adapter = mAdapter
        val lm = GridLayoutManager(requireContext(), 2)
        challenge_recyclerView2.layoutManager = lm

        view.createButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_CreateMain_to_createFirst)
        }
    }

}