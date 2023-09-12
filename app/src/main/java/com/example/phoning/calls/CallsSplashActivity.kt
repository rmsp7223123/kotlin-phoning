package com.example.phoning.calls

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityCallsSplashBinding

class CallsSplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCallsSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallsSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        Glide.with(this)
            .asGif()
            .load(R.drawable.calls_loading)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(binding.imgvLoading)

        var callDate = getIntent().getStringExtra("call_date")
        when (callDate) {
            "2023.6.27 16:10" -> binding.containerBackground.setBackgroundResource(R.drawable.calls_danielle2)
            "2023.6.16 14:05" -> binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2)
            "2023.5.17 18:30" -> binding.containerBackground.setBackgroundResource(R.drawable.calls_newjeans2)
            "2023.4.27 21:11" -> binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2)
            "2023.4.5 13:15" -> binding.containerBackground.setBackgroundResource(R.drawable.calls_hanni2)
            "2023.3.27 15:05" -> binding.containerBackground.setBackgroundResource(R.drawable.calls_haerin2)
            "2023.3.25 12:57" -> binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2)
            "2023.3.25 11:34" -> binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2)
        }
//        if (callDate == "2023.6.27 16:10") {
//            binding!!.containerBackground.setBackgroundResource(R.drawable.calls_danielle2)
//        } else if (callDate == "2023.6.16 14:05") {
//            binding!!.containerBackground.setBackgroundResource(R.drawable.calls_minji2)
//        } else if (callDate == "2023.5.17 18:30") {
//            binding!!.containerBackground.setBackgroundResource(R.drawable.calls_newjeans2)
//        } else if (callDate == "2023.4.27 21:11") {
//            binding!!.containerBackground.setBackgroundResource(R.drawable.calls_hyein2)
//        } else if (callDate == "2023.4.5 13:15") {
//            binding!!.containerBackground.setBackgroundResource(R.drawable.calls_hanni2)
//        } else if (callDate == "2023.3.27 15:05") {
//            binding!!.containerBackground.setBackgroundResource(R.drawable.calls_haerin2)
//        } else if (callDate == "2023.3.25 12:57") {
//            binding!!.containerBackground.setBackgroundResource(R.drawable.calls_hyein2)
//        } else if (callDate == "2023.3.25 11:34") {
//            binding!!.containerBackground.setBackgroundResource(R.drawable.calls_minji2)
//        }


        Handler().postDelayed({
            val intent = Intent(this, CallsOnCallActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}