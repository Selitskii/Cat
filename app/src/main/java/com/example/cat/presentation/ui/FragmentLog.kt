package com.example.cat.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cat.R
import com.example.cat.nowName

class FragmentLog : Fragment() {

    lateinit var navigation: NavController
    lateinit var btLog:Button
    lateinit var editLog:EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_log, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation = Navigation.findNavController(view)
        btLog= view.findViewById(R.id.btlogin)
        editLog= view.findViewById(R.id.editTextTextPersonName2)

        btLog.setOnClickListener {
            nowName.Name = editLog.text.toString()
            navigation.navigate(R.id.fragmentMenu)
        }

    }
}