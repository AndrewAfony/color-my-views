package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText, binding.boxFourText, binding.boxFiveText,
                binding.redButton, binding.resetButton, binding.yellowButton)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id){

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Buttons
            R.id.red_button -> binding.boxThreeText.setBackgroundResource(android.R.color.holo_red_dark)
            R.id.yellow_button -> binding.boxFiveText.setBackgroundResource(android.R.color.holo_blue_dark)

            R.id.reset_button -> binding.apply {
                boxOneText.setBackgroundResource(android.R.color.white)
                boxTwoText.setBackgroundResource(android.R.color.white)
                boxThreeText.setBackgroundResource(android.R.color.white)
                boxFourText.setBackgroundResource(android.R.color.white)
                boxFiveText.setBackgroundResource(android.R.color.white)
            }

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}