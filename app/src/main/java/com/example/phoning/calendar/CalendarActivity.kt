package com.example.phoning.calendar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityCalendarBinding
import com.example.phoning.dto.CalendarDTO
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CalendarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCalendarBinding

    private lateinit var adapter : ScheduleAdapter

    private var locale = Locale("ko", "KR")

    private var year = SimpleDateFormat("yyyy")
    private var month = SimpleDateFormat("M")
    private var day = SimpleDateFormat("d")
    private var date1 = SimpleDateFormat("E", locale)

    private var date = Date()
    private var sYear : String = year.format(date)
    private var sMonth : String = month.format(date)
    private var sDay : String = day.format(date)
    private var sDate : String = date1.format(date)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        binding.tvYear.text = sYear + "년"
        binding.tvMonth.text = sMonth + "월"
        binding.tvDay.text = sDay + "일"

        // 요일 설정
        // Sdate를 기준으로 오늘을 포함한 이후 7일 간의 요일을 계산하고, 이를 todayArr 배열에 저장합니다. 따라서 todayArr 배열에는 오늘부터 6일 후까지의 요일 정보가 저장
        val dateArr = arrayOf("일", "월", "화", "수", "목", "금", "토")
        val todayArr = arrayOfNulls<String>(7) // 크기가 7인데 모든 요소가 null인 배열로 초기화
        var k: Int // Sdate와 일치하는 요일의 인덱스를 저장할 변수
        for (i in dateArr.indices) { // dateArr 배열의 인덱스를 순회하면서 각 요일과 Sdate를 비교
            if (sDate == dateArr[i]) {
                k = i
                todayArr[0] = sDate
                for (j in 1 until dateArr.size) { // 1부터 6까지의 인덱스 범위에 대해 반복합니다. 이것은 오늘을 제외한 이후 6일 간의 요일을 계산하고 저장
                    if (k + j == dateArr.size) {
                        k = -j // 배열을 순환하면서 계속 요일을 가져오기
                    }
                    todayArr[j] = dateArr[k + j]
                    if (todayArr[1] != null && todayArr[2] != null && todayArr[3] != null && todayArr[4] != null && todayArr[5] != null && todayArr[6] != null) {
                        break // todayArr 배열의 모든 요소가 null이 아니라면, 즉, 모든 요일이 계산되었다면 루프를 종료
                    }
                }
            }
        }

        //달력 열고닫기
        binding.lnDate.setOnClickListener {
            if (binding.dp.visibility == View.GONE) {
                binding.imgvIcon.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
                binding.dp.visibility = View.VISIBLE
                binding.flBg.visibility = View.VISIBLE
            } else {
                binding.imgvIcon.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
                binding.dp.visibility = View.GONE
                binding.flBg.visibility = View.GONE
                binding.tvYear.text = binding.dp.year.toString() + "년"
                binding.tvMonth.text = (binding.dp.month + 1).toString() + "월"
                binding.tvDay.text = binding.dp.dayOfMonth.toString() + "일"
                for (i in adapter.list.indices) {
                    if (adapter.list[i].year == binding.dp.year.toString() + "년" && adapter.list[i].month == (binding.dp.month + 1).toString() + "월" && adapter.list[i].day == binding.dp.dayOfMonth.toString() + "일") {
                        (binding.recvCalendar.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(
                            i,
                            0
                        ) //맨위로 스크롤
                    }
                }
            }
        }

        //오늘날짜로 되돌리기
        binding.imgvToday.setOnClickListener {
            binding.tvYear.text = sYear + "년"
            binding.tvMonth.text = sMonth + "월"
            binding.tvDay.text = sDay + "일"
            (binding.recvCalendar.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(
                3,
                0
            )
            binding.dp.init(sYear.toInt(), sMonth.toInt() - 1, sDay.toInt(), null)
            // DatePicker를 지정된 연도, 월, 일로 설정
            // "sYear", "sMonth", "sDay" 변수에서 가져온 값을 사용하여 DatePicker의 초기 상태를 설정
        }

        val list = ArrayList<CalendarDTO>()
        list.add(
            CalendarDTO(
                sYear + "년",
                sMonth + "월",
                (sDay.toInt() - 3).toString() + "일",
                todayArr[4] + "요일"
            )
        )
        list.add(
            CalendarDTO(
                sYear + "년",
                sMonth + "월",
                (sDay.toInt() - 2).toString() + "일",
                todayArr[5] + "요일"
            )
        )
        list.add(
            CalendarDTO(
                sYear + "년",
                sMonth + "월",
                (sDay.toInt() - 1).toString() + "일",
                todayArr[6] + "요일"
            )
        )
        list.add(CalendarDTO(sYear + "년", sMonth + "월", sDay + "일", todayArr[0] + "요일"))
        list.add(
            CalendarDTO(
                sYear + "년",
                sMonth + "월",
                (sDay.toInt() + 1).toString() + "일",
                todayArr[1] + "요일"
            )
        )
        list.add(
            CalendarDTO(
                sYear + "년",
                sMonth + "월",
                (sDay.toInt() + 2).toString() + "일",
                todayArr[2] + "요일"
            )
        )
        list.add(
            CalendarDTO(
                sYear + "년",
                sMonth + "월",
                (sDay.toInt() + 3).toString() + "일",
                todayArr[3] + "요일"
            )
        )
        adapter = ScheduleAdapter(list, this)
        binding.recvCalendar.adapter = adapter
        binding.recvCalendar.layoutManager = LinearLayoutManager(this)
        (binding.recvCalendar.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(
            3,
            0
        )

        binding.imgvBack.setOnClickListener { finish() }
    }
}