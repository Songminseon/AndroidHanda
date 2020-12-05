package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import com.example.handa.R
import com.example.handa.`object`.CreateC
import kotlinx.android.synthetic.main.create_third.*


class CreateThird : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.create_third, container, false)

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CreateC.title = title_3.text.toString()
        CreateC.auth = auth_3.text.toString()
        CreateC.desc = desc_3.text.toString()
    }



    }

