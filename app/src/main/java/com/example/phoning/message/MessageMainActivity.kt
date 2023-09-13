package com.example.phoning.message

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityMessageMainBinding

class MessageMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMessageMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        binding.imgvBack.setOnClickListener { finish() }
    }
}