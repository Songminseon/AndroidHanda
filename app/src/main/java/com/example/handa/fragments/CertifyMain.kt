package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handa.*
import kotlinx.android.synthetic.main.certify_main.*


class CertifyMain : Fragment() {
    var certifylist = arrayListOf<Certify>(
        Certify("Title", "3days", 10.2, "practice"),
        Certify("Title", "3days", 10.2, "practice"),
        Certify("Title", "3days", 10.2, "practice"),
        Certify("Title", "3days", 10.2, "practice"),
        Certify("Title", "3days", 10.2, "practice"),
        Certify("Title", "3days", 10.2, "practice"),
        Certify("Title", "3days", 10.2, "practice")
    )

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.certify_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mAdapter = CertifyAdapter(requireContext(), certifylist)
        certifyList.adapter = mAdapter
        val lm = LinearLayoutManager(requireContext())
        certifyList.layoutManager=lm
        certifyList.setHasFixedSize(true)
    }
}