package com.example.phoning.calls

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityCallsCallOffSplashBinding

class CallsCallOffSplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCallsCallOffSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallsCallOffSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        val callDate = intent.getStringExtra("call_date")

        if (callDate == "2023.6.27 16:10") {
            binding.imgvBackground.setBackgroundResource(R.drawable.danielle8)
            binding.tvName.text = "다니엘_Danielle\uD83C\uDF3B"
        } else if (callDate == "2023.6.16 14:05") {
            binding.imgvBackground.setBackgroundResource(R.drawable.minji8)
            binding.tvName.text = "민지Minji\uD83E\uDDF8"
        } else if (callDate == "2023.5.17 18:30") {
            binding.imgvBackground.setBackgroundResource(R.drawable.newjeans10)
            binding.tvName.text = "NewJeans\uD83D\uDC56"
        } else if (callDate == "2023.4.27 21:11") {
            binding.imgvBackground.setBackgroundResource(R.drawable.hyein8)
            binding.tvName.text = "혜인:)Hyein\uD83D\uDC23"
        } else if (callDate == "2023.4.5 13:15") {
            binding.imgvBackground.setBackgroundResource(R.drawable.hanni11)
            binding.tvName.text = "하니_hanni_:)"
        } else if (callDate == "2023.3.27 15:05") {
            binding.imgvBackground.setBackgroundResource(R.drawable.haerin8)
            binding.tvName.text = "해린_haerin"
        } else if (callDate == "2023.3.25 12:57") {
            binding.imgvBackground.setBackgroundResource(R.drawable.hyein8)
            binding.tvName.text = "혜인:)Hyein\uD83D\uDC23"
        } else if (callDate == "2023.3.25 11:34") {
            binding.imgvBackground.setBackgroundResource(R.drawable.minji8)
            binding.tvName.text = "민지Minji\uD83E\uDDF8"
        }

        Handler().postDelayed({
            finish()
        }, 3000)
    }

}