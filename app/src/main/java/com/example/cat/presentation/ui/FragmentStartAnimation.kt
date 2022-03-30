package com.example.cat.presentation.ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.animation.addListener
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cat.R
import kotlinx.coroutines.*
import java.util.concurrent.ThreadLocalRandom

class FragmentStartAnimation : Fragment() {


    lateinit var catImageView : ImageView
    lateinit var catAnimation : AnimationDrawable
    lateinit var navigation: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_startanimation, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation = Navigation.findNavController(view)
        catImageView= view.findViewById(R.id.imgStartCat)
        catImageView.setBackgroundResource(R.drawable.happi_cat)
        catAnimation = catImageView.background as AnimationDrawable
        catAnimation.start()

        GlobalScope.async(Dispatchers.IO) {
            Thread.sleep(3500)
            GlobalScope.async (Dispatchers.Main){
                navigation.navigate(R.id.fragmentLog)
            }
        }

    }
}