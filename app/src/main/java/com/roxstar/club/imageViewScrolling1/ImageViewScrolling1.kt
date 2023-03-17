package com.roxstar.club.imageViewScrolling1

import android.animation.Animator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import com.roxstar.club.R
import kotlinx.android.synthetic.main.image_view_scrolling1.view.*
import kotlinx.android.synthetic.main.image_view_scrolling1.view.currentImage
import kotlinx.android.synthetic.main.image_view_scrolling1.view.nextImage
import kotlinx.android.synthetic.main.image_view_scrolling1_4.view.*

class ImageViewScrolling1 : FrameLayout {
    internal  lateinit var eventEnd1: IEventEnd1

    internal var last_result=1
    internal var oldValue=1
    companion object{
        private val ANIMATION_DURATION =150
    }

    var value_:Int = 0
//        get() = Integer.parseInt(nextImage.tag.toString())

    fun setEventEnd(eventEnd1: IEventEnd1){
        this.eventEnd1 = eventEnd1
    }

    constructor(context: Context):super(context){
        init(context)
    }

    constructor(context: Context,attrs: AttributeSet):super(context,attrs){
        init(context)
    }

    private fun init(context: Context){
        LayoutInflater.from(context).inflate(R.layout.image_view_scrolling1,this)

        nextImage.translationY = height.toFloat()
    }

    fun setValueRandom(image:Int,num_rotate:Int) {

        currentImage.visibility = View.VISIBLE
        currentImage.animate()
            .translationY((-height).toFloat())
            .setDuration(ANIMATION_DURATION.toLong()).start()

        nextImage.translationY = nextImage.height.toFloat()


        nextImage.animate().translationY(0f).setDuration(ANIMATION_DURATION.toLong())
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {

                }

                override fun onAnimationEnd(animation: Animator) {
                    setImage(currentImage, oldValue%6)
                    currentImage.translationY = 6f
                    if (oldValue != num_rotate) {  // If still have rotate
                        setValueRandom(image, num_rotate)
                        oldValue++
                    } else {
                        last_result = 0
                        oldValue = 0
                        setImage(nextImage, image)
                        eventEnd1.eventEnd(image%6, num_rotate) // Because we have 6 image
                    }
                }

                override fun onAnimationCancel(animation: Animator) {

                }

                override fun onAnimationRepeat(animation: Animator) {

                }
        }   ).start()
    }

    private fun setImage(img: ImageView?, value: Int) {

        if(value == Util1.kristal_1){
            img!!.setImageResource(R.drawable.kristal_1)
        }

        else if(value == Util1.kristal_2){
            img!!.setImageResource(R.drawable.kristal_2)
        }

        else if(value == Util1.kristal_3){
            img!!.setImageResource(R.drawable.kristal_3)
        }

        else if(value == Util1.kristal_4){
            img!!.setImageResource(R.drawable.kristal_4)
        }

        else if(value == Util1.kristal_5){
            img!!.setImageResource(R.drawable.kristal_5)
        }

        else if(value == Util1.kristal_6){
            img!!.setImageResource(R.drawable.kristal_6)
        }

        else if(value == Util1.kristal_7){
            img!!.setImageResource(R.drawable.kristal_7)
        }

        img!!.tag = value
        last_result = value

        value_ = value

        currentImage.visibility = View.GONE
    }
}