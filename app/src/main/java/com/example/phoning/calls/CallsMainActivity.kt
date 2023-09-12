package com.example.phoning.calls

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.common.CallsCommon
import com.example.phoning.common.CallsCommon.alarmCount
import com.example.phoning.common.CallsCommon.callCount
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

        var adapter = CallsMainAdapter(callList(),this,true)
        binding.recv.apply {
            layoutManager = LinearLayoutManager(this@CallsMainActivity)
            this.adapter = adapter
        }

//        if(CallsCommon.callCount % 2 == 1) {
//            binding.imgvBell.setImageResource(R.drawable.calls_bell)
//        } else {
//            binding.imgvBell.setImageResource(R.drawable.calls_bell2)
//        }
        binding.imgvBell.setImageResource(if (callCount % 2 == 1) R.drawable.calls_bell else R.drawable.calls_bell2)

        binding.imgvBell.setOnClickListener {
            val imageResource = if (callCount % 2 == 1) {
                Toast.makeText(this, "이제부터 통화 알림을 받지 않아요.", Toast.LENGTH_SHORT).show()
                 R.drawable.calls_bell2
            } else {
                Toast.makeText(this, "이제부터 통화 알림을 받을 수 있어요.", Toast.LENGTH_SHORT).show()
                 R.drawable.calls_bell
            }
            callCount++
            binding.imgvBell.setImageResource(imageResource)
        }

        binding.imgvCalls.setOnClickListener {
            val imageResource = if(alarmCount % 2 == 1) {
                // 통화 안 한 사람들만 보이게
                val list : ArrayList<CallsMainDTO> = callList()
                val templist : ArrayList<CallsMainDTO> = ArrayList()
                for (i in list.indices) {
                    if (!list[i].isCheck) {
                        templist.add(list[i])
                    }
                }
                adapter = CallsMainAdapter(templist, this, false)
                binding.recv.adapter = adapter
                binding.recv.layoutManager = LinearLayoutManager(this)
                R.drawable.calls_missedcall
            } else {
                // 통화 한 사람들만 보이게
                adapter = CallsMainAdapter(callList(), this, true)
                binding.recv.adapter = adapter
                binding.recv.layoutManager = LinearLayoutManager(this)
                R.drawable.calls_call
            }
            alarmCount++
            binding.imgvCalls.setImageResource(imageResource)
        }

        binding.imgvBack.setOnClickListener { finish() }
    }

    private fun callList() : ArrayList<CallsMainDTO> {
        val list = ArrayList<CallsMainDTO>()
//        list.add(
//            CallsMainDTO(
//                R.drawable.calls_danielle,
//                0,
//                "다니엘_Danielle\uD83C\uDF3B",
//                "37:46",
//                "2023.6.27 16:10",
//                CallsCommon.IsCheck[0]
//            )
//        )
//        list.add(
//            CallsMainDTO(
//                R.drawable.calls_minji,
//                0,
//                "민지Minji\uD83E\uDDF8",
//                "38:00",
//                "2023.6.16 14:05",
//                CallsCommon.IsCheck[1]
//            )
//        )
//        list.add(
//            CallsMainDTO(
//                R.drawable.calls_newjeans,
//                0,
//                "NewJeans\uD83D\uDC56",
//                "29:05",
//                "2023.5.17 18:30",
//                CallsCommon.IsCheck[2]
//            )
//        )
//        list.add(
//            CallsMainDTO(
//                R.drawable.calls_hyein,
//                0,
//                "혜인:)Hyein\uD83D\uDC23",
//                "37:46",
//                "2023.4.27 21:11",
//                CallsCommon.IsCheck[3]
//            )
//        )
//        list.add(
//            CallsMainDTO(
//                R.drawable.calls_hanni,
//                0,
//                "하니_hanni_:)",
//                "51:34",
//                "2023.4.5 13:15",
//                CallsCommon.IsCheck[4]
//            )
//        )
//        list.add(
//            CallsMainDTO(
//                R.drawable.calls_haerin,
//                0,
//                "해린_haerin",
//                "26:20",
//                "2023.3.27 15:05",
//                CallsCommon.IsCheck[5]
//            )
//        )
//        list.add(
//            CallsMainDTO(
//                R.drawable.calls_hyein,
//                0,
//                "혜인:)Hyein\uD83D\uDC23",
//                "07:14",
//                "2023.3.25 12:57",
//                CallsCommon.IsCheck[6]
//            )
//        )
//        list.add(
//            CallsMainDTO(
//                R.drawable.calls_minji,
//                0,
//                "민지\uD83C\uDF80",
//                "45:45",
//                "2023.3.25 11:34",
//                CallsCommon.IsCheck[7]
//            )
//        )
        val isCheckArray = CallsCommon.IsCheck
        val names = arrayOf(
            "다니엘_Danielle\uD83C\uDF3B",
            "민지Minji\uD83E\uDDF8",
            "NewJeans\uD83D\uDC56",
            "혜인:)Hyein\uD83D\uDC23",
            "하니_hanni_:)",
            "해린_haerin",
            "혜인:)Hyein\uD83D\uDC23",
            "민지\uD83C\uDF80"
        )

        val callsNames = arrayOf("calls_danielle", "calls_minji", "calls_newjeans", "calls_hyein", "calls_hanni", "calls_haerin", "calls_hyein", "calls_minji")
        val callTimes = arrayOf("37:46", "38:00", "29:05", "37:46", "51:34", "26:20", "07:14", "45:45")
        val callDates = arrayOf(
            "2023.6.27 16:10", "2023.6.16 14:05", "2023.5.17 18:30", "2023.4.27 21:11",
            "2023.4.5 13:15", "2023.3.27 15:05", "2023.3.25 12:57", "2023.3.25 11:34"
        )

        for (i in names.indices) {
            //for in 루프 for (element in collection) 형태 컬렉션을 반복하면서 요소에 차례로 접근
            //ex) for (i in 1..10) 1에서 10까지 반복
            //in 연산자 값이 범위 또는 컬렉션에 속하는지 확인하는 데 사용
            //ex) 5 in 1..10은 true
            //indices 배열이나 리스트의 인덱스 집합을 나타내는 속성
            //indices를 사용하면 해당 컬렉션의 유효한 인덱스 범위에 대한 정보를 얻을 수 있음
            list.add(
                CallsMainDTO(
                    getDrawableResourceId(callsNames[i].lowercase()),
                    // $ = 문자열 내에서 변수나 표현식을 평가하여 문자열로 대체하는 데 사용
                    0,
                    names[i],
                    callTimes[i],
                    callDates[i],
                    isCheckArray[i]
                )
            )
        }
        return list
    }

    private fun getDrawableResourceId(resourceName: String): Int {
        return resources.getIdentifier(resourceName, "drawable", packageName)
        // resources 리소스접근
        // getIdentifier 리소스 식별자(ResID)를 검색
        // resourceName 리소스이름
        // drawable 리소스 타입 지정 (drawable 리소스의 식별자)
        // packageName 해당 디렉터리에서 리소스를 검색
    }
}