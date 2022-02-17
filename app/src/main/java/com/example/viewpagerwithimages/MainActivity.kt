package com.example.viewpagerwithimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var cv1:CardView
    private lateinit var cv2:CardView
    private lateinit var cv3:CardView
    private lateinit var iv1:ImageView
    private lateinit var iv2:ImageView
    private lateinit var iv3:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewPager2=findViewById(R.id.viewpager)
        cv1=findViewById(R.id.cv1)
        cv2=findViewById(R.id.cv2)
        cv3=findViewById(R.id.cv3)

        iv1=findViewById(R.id.iv1)
        iv2=findViewById(R.id.iv2)
        iv3=findViewById(R.id.iv3)

        val images= listOf(R.drawable.atmosphere_bg,R.drawable.clear_bg,R.drawable.clouds_bg)
        val adapter=ViewPagerAdapter(images)
        viewPager2.adapter=adapter

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                Log.d("TAG","CALLED 1")
                changeColor()
                super.onPageSelected(position)
                Log.d("TAG","CALLED 2")

            }

            override fun onPageScrollStateChanged(state: Int) {
                Log.d("TAG","CALLED 3")
                super.onPageScrollStateChanged(state)
                Log.d("TAG","CALLED 4")
                changeColor()

            }

            override fun onPageScrolled(position: Int,
                                        positionOffset: Float,
                                        positionOffsetPixels: Int) {
                Log.d("TAG","CALLED 5")
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                Log.d("TAG","CALLED 6")

            }
        })

        Log.d("TAG",""+viewPager2.currentItem)


    }
    fun changeColor()
    {

        val value=viewPager2.currentItem

        if(value==0) {

            iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
            iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.purple_200))
            iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.purple_200))
        } else if (value==1) {
            iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.purple_200))
            iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
            iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.purple_200))
        } else if (value==2) {
            iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.purple_200))
            iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.purple_200))
            iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
        }
    }
}