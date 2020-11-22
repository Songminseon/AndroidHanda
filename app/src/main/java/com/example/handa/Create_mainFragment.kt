package com.example.handa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.handa.databinding.CreateMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Create_mainFragment : Fragment() {

    override fun onCreateView(inflater:LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{

        val binding = DataBindingUtil.inflate<CreateMainBinding>(inflater,
            R.layout.create_main,container,false)


        return binding.root
    }


}