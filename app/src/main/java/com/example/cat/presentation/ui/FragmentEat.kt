package com.example.cat.presentation.ui

import android.animation.ObjectAnimator
import android.graphics.Rect
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.animation.addListener
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cat.R

class FragmentEat : Fragment() {

    var score :Int = 0;
    val bundle = Bundle()

    lateinit var appleImageView : ImageView
    lateinit var milkImageView : ImageView
    lateinit var eatImageView : ImageView
    lateinit var  catImageView : ImageView
    var speed:Long = 5000

    lateinit var lineImageView : ImageView
    lateinit var btFeed: Button
    lateinit var bt: Button
    lateinit var textScore : TextView
    lateinit var textScore2 : TextView

    lateinit var catAnimation : AnimationDrawable
    lateinit var  appleAnimation: ObjectAnimator
    lateinit var  milkAnimation: ObjectAnimator
    lateinit var eatAnimation: ObjectAnimator
    lateinit var navigation: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_eat, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        startAnim()

        btFeed.setOnClickListener {
            var  view_rect_apple : Rect =  Rect()
            var  view_rect_milk : Rect =  Rect()
            var  view_rect_eat : Rect =  Rect()
            appleImageView.getGlobalVisibleRect(view_rect_apple)
            milkImageView.getGlobalVisibleRect(view_rect_milk)
            eatImageView.getGlobalVisibleRect(view_rect_eat)
            //textScore2.text=view_rect_apple.top.toInt().toString()
            //textScore.text=lineImageView.y.toInt().toString()
            if(((view_rect_apple.top.toInt())>lineImageView.y.toInt())&&((view_rect_apple.top.toInt()-300)<lineImageView.y))
            {
                score++;
                textScore.text=score.toString()

                appleImageView.visibility = View.INVISIBLE
                appleAnimation.duration= 0
                appleAnimation.reverse()

                startAnim()
            }else  if((( view_rect_milk.top.toInt())>lineImageView.y.toInt())&&(( view_rect_milk.top.toInt()-300)<lineImageView.y))
            {
                score++;
                textScore.text=score.toString()

                milkImageView.visibility = View.INVISIBLE
                milkAnimation.duration = 0
                milkAnimation.reverse()

                startAnim()
            } else  if(((view_rect_eat.top.toInt())>lineImageView.y.toInt())&&((view_rect_eat.top.toInt()-300)<lineImageView.y))
            {
                score++;
                textScore.text=score.toString()

                eatImageView.visibility = View.INVISIBLE
                eatAnimation.duration = 0
                eatAnimation.reverse()

                startAnim()
            }else{
                end()
            }
            if((score % 15)==0){
                catAnimation.stop()
                catAnimation.start()
            }
        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation = Navigation.findNavController(view)
        appleImageView = view.findViewById(R.id.imgApple)
        milkImageView = view.findViewById(R.id.imgMilk)
        eatImageView = view.findViewById(R.id.imgEat)
        catImageView = view.findViewById(R.id.imgCat)
        lineImageView = view.findViewById(R.id.ImgLine)
        btFeed= view.findViewById((R.id.BtFeed))
        bt = view.findViewById((R.id.button2))
        textScore = view.findViewById(R.id.TextScore)
        textScore2 = view.findViewById(R.id.TextScore2)

        catImageView.setBackgroundResource(R.drawable.happi_cat)
        catAnimation = catImageView.background as AnimationDrawable

        appleAnimation = ObjectAnimator.ofFloat(appleImageView,"translationY", 1500f).apply {
            addListener(onEnd = {
                start()
            })
        }
        milkAnimation = ObjectAnimator.ofFloat(milkImageView,"translationY", 1500f).apply {
            addListener(onEnd = {
                start()
            })
        }
        eatAnimation = ObjectAnimator.ofFloat(eatImageView,"translationY", 1500f).apply {
            addListener(onEnd = {
                start()
            })
        }
    }

    fun startAnim (){
        var kl = 0
        val rnds = randomEat(kl)
        if (speed > 2000) {
            speed = speed - 100
        }
                    if (rnds == 1){
                       appleImageView.visibility = View.VISIBLE
                        appleAnimation.duration = speed
                        appleAnimation.start()
                    }else if (rnds == 2){
                       milkImageView.visibility = View.VISIBLE
                        milkAnimation.duration = speed
                        milkAnimation.start()
                    }else if (rnds == 3){
                       eatImageView.visibility = View.VISIBLE
                        eatAnimation.duration = speed
                        eatAnimation.start()
                    }
    }

    fun randomEat(kl:Int):Int{
        val rnds = (1..3).random()
        if(kl==rnds){
            return randomEat(kl)
        }
        return rnds
    }

    fun end(){
        bundle.putInt("Score",score)
        navigation.navigate(R.id.fragmentEnd,bundle)
        score = 0
    }
}