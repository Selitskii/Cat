package com.example.cat.presentation.ui

import android.content.ActivityNotFoundException
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast


import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.content.Intent.createChooser
import android.widget.Button
import androidx.annotation.RestrictTo
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cat.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.*


class FragmentEnd: Fragment() {

    lateinit var navigation: NavController
    val bundle = Bundle()
    lateinit var textScore: TextView
    lateinit var btShare :Button
    lateinit var btOk :Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_end, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: AppDatabase? = App.instance?.database
        val userDao:UserDao = db?.userDao()!!

        navigation = Navigation.findNavController(view)
        textScore = view.findViewById(R.id.textScore)
        btShare = view.findViewById(R.id.btShare)
        btOk= view.findViewById(R.id.btok)
        textScore.text= arguments?.getInt("Score").toString()

        btShare.setOnClickListener {
           val myItent :Intent = Intent(ACTION_SEND)
            myItent.setType("text/plain")
            val shareSub = "cat"
            myItent.putExtra(Intent.EXTRA_SUBJECT,shareSub)
            myItent.putExtra(Intent.EXTRA_TEXT,"My score in Cat"+textScore.text.toString())
            startActivity(createChooser(myItent,"Share"))
        }

        btOk.setOnClickListener {
           GlobalScope.launch {
               userDao.insert(
                   User(
                       name = nowName.Name,
                       date = Calendar.getInstance().time.toString(),
                       score = textScore.text.toString(),
                       id = 0
                   )
               )
           }
            navigation.navigate(R.id.fragmentMenu)
        }
    }
}