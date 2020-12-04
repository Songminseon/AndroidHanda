package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.R
import kotlinx.android.synthetic.main.create_fifth.view.*

class CreateFifth : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_fifth, container, false)
    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        view.radioGroup5.setOnCheckedChangeListener{ radioGroup: RadioGroup, i: Int ->
//            when (i){
//                R.id.f_rb1 ->{
//                    view.findNavController().navigate(R.id.action_createFifth_to_createSixth)
//                }
//                R.id.f_rb2 ->{
//                    view.findNavController().navigate(R.id.action_createFifth_to_createSixth)
//
//                }
//                R.id.f_rb3 ->{
//                    view.findNavController().navigate(R.id.action_createFifth_to_createSixth)
//                }
//                R.id.f_rb4 ->{
//                    view.findNavController().navigate(R.id.action_createFifth_to_createSixth)
//                }
//                R.id.f_rb5 ->{
//                    view.findNavController().navigate(R.id.action_createFifth_to_createSixth)
//                }
//            }
//
//        }
//    }
}