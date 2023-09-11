package com.example.phoning.calls

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.databinding.ActivityCallsMainBinding

class CallsMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCallsMainBinding

    private var count : Int = 1

    private var count2 : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        binding.imgvBack.setOnClickListener { finish() }
    }
}