package com.example.handa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.handa.databinding.CertifyMainBinding


class Certify_mainFragment : Fragment() {

    override fun onCreateView(inflater:LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{

        val binding = DataBindingUtil.inflate<CertifyMainBinding>(inflater,
            R.layout.certify_main,container,false)
        return binding.root
    }

}