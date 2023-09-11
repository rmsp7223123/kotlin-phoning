package com.example.phoning.calls

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.common.CallsCommon
import com.example.phoning.databinding.ActivityCallsMainBinding
import com.example.phoning.dto.CallsMainDTO

class CallsMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCallsMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        val adapter = CallsMainAdapter(callList(),this,true)
        binding.recv.apply {
            layoutManager = LinearLayoutManager(this@CallsMainActivity)
            this.adapter = adapter
        }

        if(CallsCommon.callCount % 2 == 1) {
            binding.imgvBell.setImageResource(R.drawable.calls_bell)
        } else {
            binding.imgvBell.setImageResource(R.drawable.calls_bell2)
        }

        binding.imgvBell.setOnClickListener {
            if(CallsCommon.callCount % 2 == 1) {
                binding.imgvBell.setImageResource(R.drawable.calls_bell2)
                Toast.makeText(this, "이제부터 통화 알림을 받지 않아요.", Toast.LENGTH_SHORT).show()
            } else {
                binding.imgvBell.setImageResource(R.drawable.calls_bell)
                Toast.makeText(this, "이제부터 통화 알림을 받을 수 있어요.", Toast.LENGTH_SHORT).show()
            }
            CallsCommon.callCount ++
        }

        binding.imgvBack.setOnClickListener { finish() }

    }

    private fun callList() : ArrayList<CallsMainDTO> {
        val list = ArrayList<CallsMainDTO>()
        list.add(
            CallsMainDTO(
                R.drawable.calls_danielle,
                0,
                "다니엘_Danielle\uD83C\uDF3B",
                "37:46",
                "2023.6.27 16:10",
                CallsCommon.IsCheck[0]
            )
        )
        list.add(
            CallsMainDTO(
                R.drawable.calls_minji,
                0,
                "민지Minji\uD83E\uDDF8",
                "38:00",
                "2023.6.16 14:05",
                CallsCommon.IsCheck[1]
            )
        )
        list.add(
            CallsMainDTO(
                R.drawable.calls_newjeans,
                0,
                "NewJeans\uD83D\uDC56",
                "29:05",
                "2023.5.17 18:30",
                CallsCommon.IsCheck[2]
            )
        )
        list.add(
            CallsMainDTO(
                R.drawable.calls_hyein,
                0,
                "혜인:)Hyein\uD83D\uDC23",
                "37:46",
                "2023.4.27 21:11",
                CallsCommon.IsCheck[3]
            )
        )
        list.add(
            CallsMainDTO(
                R.drawable.calls_hanni,
                0,
                "하니_hanni_:)",
                "51:34",
                "2023.4.5 13:15",
                CallsCommon.IsCheck[4]
            )
        )
        list.add(
            CallsMainDTO(
                R.drawable.calls_haerin,
                0,
                "해린_haerin",
                "26:20",
                "2023.3.27 15:05",
                CallsCommon.IsCheck[5]
            )
        )
        list.add(
            CallsMainDTO(
                R.drawable.calls_hyein,
                0,
                "혜인:)Hyein\uD83D\uDC23",
                "07:14",
                "2023.3.25 12:57",
                CallsCommon.IsCheck[6]
            )
        )
        list.add(
            CallsMainDTO(
                R.drawable.calls_minji,
                0,
                "민지\uD83C\uDF80",
                "45:45",
                "2023.3.25 11:34",
                CallsCommon.IsCheck[7]
            )
        )
        return list
    }
}