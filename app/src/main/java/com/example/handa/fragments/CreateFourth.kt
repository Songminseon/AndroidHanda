package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.R
import com.example.handa.`object`.Cat
import com.example.handa.`object`.CreateC
import com.example.handa.dataclass.C_post
import com.example.handa.dataclass.Challenge
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.create_fourth.*



class CreateFourth : Fragment() {

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private lateinit var auth: FirebaseAuth
    private var num:Int = 0


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.create_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        radioGroup4.setOnCheckedChangeListener{ radioGroup: RadioGroup, i: Int ->
            when (i){
                R.id.fourth_rb1 ->{
                    CreateC.term=1*7
                }
                R.id.fourth_rb2 ->{
                    CreateC.term=2*7
                }
                R.id.fourth_rb3 ->{
                    CreateC.term=3*7
                }
                R.id.fourth_rb4 ->{
                    CreateC.term=4*7
                }
                R.id.fourth_rb5 ->{
                    fourth_et.visibility=View.VISIBLE
                    CreateC.term=fourth_et.text.toString().toInt()*7
                }
            }
        }
        button_f.setOnClickListener{
            count_li()
            enter()
            CreateC.fee=fee_et.text.toString().toInt()
            view.findNavController().navigate(R.id.action_createFourth_to_CreateMain)

        }
    }

    fun enter(){
        val user = auth.currentUser
        val DatabaseReference = database.reference
        val data = C_post(CreateC.title,CreateC.term,CreateC.term,CreateC.fee,CreateC.desc,CreateC.auth,CreateC.rep,CreateC.cat,0,0)
        val info = data.toMap_c()
        DatabaseReference.child("userChallenge").child(user?.uid.toString()).child(num.toString()).setValue(info)
        if(CreateC.cat=="diet"){
            Cat.category_d.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )
            Cat.category_t.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )

        }
        if(CreateC.cat=="study"){
            Cat.category_s.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )
            Cat.category_t.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )

        }
        if(CreateC.cat=="lifestyle"){
            Cat.category_r.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )
            Cat.category_t.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )

        }

        if(CreateC.cat=="hobby"){
            Cat.category_h.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )
            Cat.category_t.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )

        }

        if(CreateC.cat=="language"){
            Cat.category_l.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )
            Cat.category_t.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )

        }

        if(CreateC.cat=="money"){
            Cat.category_m.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )
            Cat.category_t.add(
                    Challenge(
                            CreateC.cat,
                            CreateC.title,
                            CreateC.term.toString(),
                            CreateC.term.toString(),
                            CreateC.rep
                    )
            )

        }
        //초기
        CreateC.title=""
        CreateC.term=0
        CreateC.fee=0
        CreateC.desc=""
        CreateC.auth=""
        CreateC.rep=""
        CreateC.cat=""
    }

    fun count_li() {
        auth=FirebaseAuth.getInstance()
        val user = auth.currentUser
        val data = database.getReference("userChallenge")
        data.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    if (i.key == user!!.uid) {
                        for (j in i.children) {
                            num += 1
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }
}