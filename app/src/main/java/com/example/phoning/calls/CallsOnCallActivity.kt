package com.example.phoning.calls

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.databinding.ActivityCallsOnCallBinding

class CallsOnCallActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCallsOnCallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallsOnCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        binding.imgvCalloff.setOnClickListener {
            finish()
        }
    }
}