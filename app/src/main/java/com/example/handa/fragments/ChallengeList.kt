package com.example.handa.fragments


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.handa.*
import com.example.handa.databinding.ChallengeListBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
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
        mStorageRef = FirebaseStorage.getInstance().reference

        val data= database.getReference("challenge")
        data.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ch in snapshot.children) {
                    if (ch.child("category").value.toString() == Cat.cat) {
                        val image=ch.child("image").value.toString()
                        val mountainRef = mStorageRef!!.child("publicDiet/$image").downloadUrl
                            .addOnSuccessListener{ imageURL=it }
                            .addOnFailureListener{}
                        Cat.category_d.add(Challenge(
                            ch.child("category").value.toString(),
                            ch.child("title").value.toString(),
                            ch.child("remain").value.toString(),
                            ch.child("term").value.toString(),
                            imageURL))
                    }
                    if (ch.child("category").value.toString() == Cat.cat) {
                        val image=ch.child("image").value.toString()
                        val mountainRef = mStorageRef!!.child("publicStudy/$image").downloadUrl
                            .addOnSuccessListener{ imageURL=it }
                            .addOnFailureListener{}
                        Cat.category_s.add(Challenge(
                            ch.child("category").value.toString(),
                            ch.child("title").value.toString(),
                            ch.child("remain").value.toString(),
                            ch.child("term").value.toString(),
                            imageURL))
                    }
                    if (ch.child("category").value.toString() == Cat.cat) {
                        val image=ch.child("image").value.toString()
                        val mountainRef = mStorageRef!!.child("publicHobby/$image").downloadUrl
                            .addOnSuccessListener{ imageURL=it }
                            .addOnFailureListener{}
                        Cat.category_h.add(Challenge(
                            ch.child("category").value.toString(),
                            ch.child("title").value.toString(),
                            ch.child("remain").value.toString(),
                            ch.child("term").value.toString(),
                            imageURL))
                    }
                    if (ch.child("category").value.toString() == Cat.cat) {
                        val image=ch.child("image").value.toString()
                        val mountainRef = mStorageRef!!.child("publicMoney/$image").downloadUrl
                            .addOnSuccessListener{ imageURL=it }
                            .addOnFailureListener{}
                        Cat.category_m.add(Challenge(
                            ch.child("category").value.toString(),
                            ch.child("title").value.toString(),
                            ch.child("remain").value.toString(),
                            ch.child("term").value.toString(),
                            imageURL))
                    }
                    if (ch.child("category").value.toString() == Cat.cat) {
                        val image=ch.child("image").value.toString()
                        val mountainRef = mStorageRef!!.child("publicLanguage/$image").downloadUrl
                            .addOnSuccessListener{ imageURL=it }
                            .addOnFailureListener{}
                        Cat.category_l.add(Challenge(
                            ch.child("category").value.toString(),
                            ch.child("title").value.toString(),
                            ch.child("remain").value.toString(),
                            ch.child("term").value.toString(),
                            imageURL))
                    }
                    if (ch.child("category").value.toString() == Cat.cat) {
                        val image=ch.child("image").value.toString()
                        val mountainRef = mStorageRef!!.child("publicDaily/$image").downloadUrl
                            .addOnSuccessListener{ imageURL=it }
                            .addOnFailureListener{}
                        Cat.category_r.add(Challenge(
                            ch.child("category").value.toString(),
                            ch.child("title").value.toString(),
                            ch.child("remain").value.toString(),
                            ch.child("term").value.toString(),
                            imageURL))
                    }


                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

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