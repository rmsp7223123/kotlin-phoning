package com.example.phoning.calls

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityCallsOnCallBinding

class CallsOnCallActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCallsOnCallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallsOnCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        var callDate = intent.getStringExtra("call_date")

        var zoomCount = 1

        binding.imgvZoom.setOnClickListener {
            if (zoomCount % 2 == 1) binding.imgvZoom.setImageResource(R.drawable.calls_call_reduction)
            else binding.imgvZoom.setImageResource(R.drawable.calls_call_expansion)
            zoomCount++
        }

        binding.containerCall.visibility = View.INVISIBLE
        binding.containerBackground.setOnClickListener {
            if (binding.containerCall.visibility === View.INVISIBLE) binding.containerCall.visibility = View.VISIBLE
            else  binding.containerCall.visibility = View.INVISIBLE
        }

        when (callDate) {
            "2023.6.27 16:10" -> {
                binding.containerBackground.setBackgroundResource(R.drawable.calls_danielle2)
                binding.tvName.text = "다니엘_Danielle\uD83C\uDF3B"
                binding.tvCallTotaltime.text = "00:37:46"
            }
            "2023.6.16 14:05" -> {
                binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2)
                binding.tvName.text = "민지Minji\uD83E\uDDF8"
                binding.tvCallTotaltime.text = "00:38:00"
            }
            "2023.5.17 18:30" -> {
                binding.containerBackground.setBackgroundResource(R.drawable.calls_newjeans2)
                binding.tvName.text = "NewJeans\uD83D\uDC56"
                binding.tvCallTotaltime.text = "00:29:05"
            }
            "2023.4.27 21:11" -> {
                binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2)
                binding.tvName.text = "혜인:)Hyein\uD83D\uDC23"
                binding.tvCallTotaltime.text = "00:37:46"
            }
            "2023.4.5 13:15" -> {
                binding.containerBackground.setBackgroundResource(R.drawable.calls_hanni2)
                binding.tvName.text = "하니_hanni_:)"
                binding.tvCallTotaltime.text = "00:51:34"
            }
            "2023.3.27 15:05" -> {
                binding.containerBackground.setBackgroundResource(R.drawable.calls_haerin2)
                binding.tvName.text = "해린_haerin"
                binding.tvCallTotaltime.text = "00:26:20"
            }
            "2023.3.25 12:57" -> {
                binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2)
                binding.tvName.text = "혜인:)Hyein\uD83D\uDC23"
                binding.tvCallTotaltime.text = "00:07:14"
            }
            "2023.3.25 11:34" -> {
                binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2)
                binding.tvName.text = "민지Minji\uD83E\uDDF8"
                binding.tvCallTotaltime.text = "00:45:45"
            }
        }
        binding.imgvCalloff.setOnClickListener {
            finish()
        }
    }
}