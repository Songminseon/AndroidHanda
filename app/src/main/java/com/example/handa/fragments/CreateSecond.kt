package com.example.handa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.R
import kotlinx.android.synthetic.main.create_main.view.*
import kotlinx.android.synthetic.main.create_second.view.*

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
        view.radioGroup.setOnCheckedChangeListener{group,checkedId ->

        }

    }

}