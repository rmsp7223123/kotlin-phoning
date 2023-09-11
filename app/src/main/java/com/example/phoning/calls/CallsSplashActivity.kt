package com.example.phoning.calls

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.databinding.ActivityCallsSplashBinding

class CallsSplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCallsSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallsSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        Handler().postDelayed({
            val intent = Intent(this, CallsOnCallActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}