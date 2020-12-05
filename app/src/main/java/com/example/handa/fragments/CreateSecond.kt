package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.R
import com.example.handa.`object`.CreateC
import kotlinx.android.synthetic.main.create_second.*


class CreateSecond : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.create_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        radioGroup2.setOnCheckedChangeListener{ radioGroup: RadioGroup, i: Int ->
            when (i){
                R.id.second_rb1 ->{
                    CreateC.cat="diet"
                    view.findNavController().navigate(R.id.action_createSecond_to_createThird)
                }
                R.id.second_rb2 ->{
                    CreateC.cat="study"
                    view.findNavController().navigate(R.id.action_createSecond_to_createThird)
                }
                R.id.second_rb3 ->{
                    CreateC.cat="lifestyle"
                    view.findNavController().navigate(R.id.action_createSecond_to_createThird)
                }
                R.id.second_rb4 ->{
                    CreateC.cat="hobby"
                    view.findNavController().navigate(R.id.action_createSecond_to_createThird)
                }
                R.id.second_rb5 ->{
                    CreateC.cat="language"
                    view.findNavController().navigate(R.id.action_createSecond_to_createThird)
                }
                R.id.second_rb6 ->{
                    CreateC.cat="money"
                    view.findNavController().navigate(R.id.action_createSecond_to_createThird)
                }
            }
        }
    }

}