package com.example.phoning.calendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityCalendarBinding

class CalendarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        binding.imgvBack.setOnClickListener { finish() }
    }
}