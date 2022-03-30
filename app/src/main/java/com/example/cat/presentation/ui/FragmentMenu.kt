package com.example.cat.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.ViewAnimator
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cat.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FragmentMenu : Fragment() {

    lateinit var btPlay:Button
    lateinit var btResult:Button
    lateinit var btAbout:Button
    lateinit var navigation: NavController
    lateinit var  animator: Animation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*
        animator = AnimationUtils.loadAnimation(
            this.context,R.anim.rotatebt)
*/
        navigation = Navigation.findNavController(view)
        btPlay=view.findViewById(R.id.btplay)
        btResult=view.findViewById(R.id.btResult)
        btAbout=view.findViewById(R.id.btabout)


        btPlay.setOnClickListener {
            navigation.navigate(R.id.fragmentEat4)
        }
        btResult.setOnClickListener {
            navigation.navigate(R.id.fragmentResult)

        }
        btAbout.setOnClickListener {
            navigation.navigate(R.id.fragmentAbout)
        }

    }
}