package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.handa.R
import kotlinx.android.synthetic.main.create_fourth.*



class CreateFourth : Fragment() {

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

                }
                R.id.fourth_rb2 ->{

                }
                R.id.fourth_rb3 ->{

                }
                R.id.fourth_rb4 ->{

                }
                R.id.fourth_rb5 ->{
                    fourth_et.visibility=View.VISIBLE

                }
            }
        }
    }

}