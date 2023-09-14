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
import java.util.Calendar
import java.util.Date
import java.util.Locale

class CalendarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalendarBinding

    private lateinit var adapter: ScheduleAdapter

    private var locale = Locale("ko", "KR")

    private var year = SimpleDateFormat("yyyy")
    private var month = SimpleDateFormat("M")
    private var day = SimpleDateFormat("d")
    private var date1 = SimpleDateFormat("E", locale) // 로케일을 적용하여 요일을 한글로 가져옴

    private var date = Date()
    private var sYear: String = year.format(date)
    private var sMonth: String = month.format(date)
    private var sDay: String = day.format(date)
    private var sDate: String = date1.format(date)

    private var all = true
    private var newjeans = false
    private var minji = false
    private var hanni = false
    private var danielle = false
    private var hyein = false
    private var haerin = false


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
                    if (adapter.list[i].year == binding.dp.year.toString() + "년" && adapter.list[i].month == (binding.dp.month + 1).toString() + "월" && adapter.list[i].date == binding.dp.dayOfMonth.toString() + "일") {
                        (binding.recvCalendar.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(
                            i,
                            0
                        ) //맨위로 스크롤
                    }
                }
            }
        }
        

        binding.imgvAll.setOnClickListener {
            if (!all) {
                all = true
                binding.imgvAll.setImageResource(R.drawable.calendar_all_checked)
                newjeans = false
                binding.imgvNewjeans.setImageResource(R.drawable.calendar_newjeans)
                minji = false
                binding.imgvMinji.setImageResource(R.drawable.calendar_minji)
                hanni = false
                binding.imgvHanni.setImageResource(R.drawable.calendar_hanni)
                danielle = false
                binding.imgvDanielle.setImageResource(R.drawable.calendar_danielle)
                hyein = false
                binding.imgvHyein.setImageResource(R.drawable.calendar_hyein)
                haerin = false
                binding.imgvHaerin.setImageResource(R.drawable.calendar_haerin)
            }
        }
        binding.imgvNewjeans.setOnClickListener {
            if (newjeans) {
                newjeans = false
                binding.imgvNewjeans.setImageResource(R.drawable.calendar_newjeans)
                if (!newjeans && !minji && !hanni && !danielle && !hyein && !haerin) {
                    all = true
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked)
                }
            } else {
                newjeans = true
                binding.imgvNewjeans.setImageResource(R.drawable.calendar_newjeans_checked)
                all = false
                binding.imgvAll.setImageResource(R.drawable.calendar_all)
            }
        }
        binding.imgvMinji.setOnClickListener {
            if (minji) {
                minji = false
                binding.imgvMinji.setImageResource(R.drawable.calendar_minji)
                if (!newjeans && !minji && !hanni && !danielle && !hyein && !haerin) {
                    all = true
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked)
                }
            } else {
                minji = true
                binding.imgvMinji.setImageResource(R.drawable.calendar_minji_checked)
                all = false
                binding.imgvAll.setImageResource(R.drawable.calendar_all)
            }
        }
        binding.imgvHanni.setOnClickListener {
            if (hanni) {
                hanni = false
                binding.imgvHanni.setImageResource(R.drawable.calendar_hanni)
                if (!newjeans && !minji && !hanni && !danielle && !hyein && !haerin) {
                    all = true
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked)
                }
            } else {
                hanni = true
                binding.imgvHanni.setImageResource(R.drawable.calendar_hanni_checked)
                all = false
                binding.imgvAll.setImageResource(R.drawable.calendar_all)
            }
        }
        binding.imgvDanielle.setOnClickListener {
            if (danielle) {
                danielle = false
                binding.imgvDanielle.setImageResource(R.drawable.calendar_danielle)
                if (!newjeans && !minji && !hanni && !danielle && !hyein && !haerin) {
                    all = true
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked)
                }
            } else {
                danielle = true
                binding.imgvDanielle.setImageResource(R.drawable.calendar_danielle_checked)
                all = false
                binding.imgvAll.setImageResource(R.drawable.calendar_all)
            }
        }
        binding.imgvHyein.setOnClickListener {
            if (hyein) {
                hyein = false
                binding.imgvHyein.setImageResource(R.drawable.calendar_hyein)
                if (!newjeans && !minji && !hanni && !danielle && !hyein && !haerin) {
                    all = true
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked)
                }
            } else {
                hyein = true
                binding.imgvHyein.setImageResource(R.drawable.calendar_hyein_checked)
                all = false
                binding.imgvAll.setImageResource(R.drawable.calendar_all)
            }
        }
        binding.imgvHaerin.setOnClickListener {
            if (haerin) {
                haerin = false
                binding.imgvHaerin.setImageResource(R.drawable.calendar_haerin)
                if (!newjeans && !minji && !hanni && !danielle && !hyein && !haerin) {
                    all = true
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked)
                }
            } else {
                haerin = true
                binding.imgvHaerin.setImageResource(R.drawable.calendar_haerin_checked)
                all = false
                binding.imgvAll.setImageResource(R.drawable.calendar_all)
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


        val dayOffset = -3 // 현재 날짜에서 몇 일 전부터 보여줄지 결정
        val list = (0 until 7).map { i ->
            // map 함수는 리스트나 배열의 각 요소에 대해 주어진 람다 함수를 적용하고 그 결과를 새로운 리스트로 반환
            val calendar =
                Calendar.getInstance().apply { add(Calendar.DAY_OF_MONTH, dayOffset + i) }
            // Calendar.getInstance()를 사용하여 현재 시스템 시간과 날짜 정보가 포함된 Calendar 객체를 생성
            // Calendar.DAY_OF_MONTH 필드에 dayOffset + i 값을 더해주어 해당 날짜를 계산
            // dayOffset은 현재 날짜에서 몇 일 전부터 보여줄지를 나타내는 변수
            // i는 0부터 6까지의 값을 가지며 오늘로부터 몇 일 후의 날짜를 계산
            val dayOfWeek = when (calendar.get(Calendar.DAY_OF_WEEK)) {
                Calendar.SUNDAY -> "일요일"
                Calendar.MONDAY -> "월요일"
                Calendar.TUESDAY -> "화요일"
                Calendar.WEDNESDAY -> "수요일"
                Calendar.THURSDAY -> "목요일"
                Calendar.FRIDAY -> "금요일"
                Calendar.SATURDAY -> "토요일"
                else -> ""
            }
            CalendarDTO(
                "${calendar.get(Calendar.YEAR)}년",
                "${calendar.get(Calendar.MONTH) + 1}월",
                "${calendar.get(Calendar.DAY_OF_MONTH)}일",
                dayOfWeek
            )
        }

//        val list = ArrayList<CalendarDTO>()
//        val dayOffset = -3
//
//        for (i in 0 until 7) {
//            // 0 until 7은 0부터 6까지의 범위를 나타내며, until 키워드는 시작 값을 포함하고 종료 값을 포함하지 않는 범위를 생성
//            val calendar = Calendar.getInstance()
//            calendar.add(Calendar.DAY_OF_MONTH, dayOffset + i)
//
//            val year = calendar.get(Calendar.YEAR)
//            val month = calendar.get(Calendar.MONTH) + 1
//            val day = calendar.get(Calendar.DAY_OF_MONTH)
//            val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
//
//            list.add(CalendarDTO(
//                "${year}년",
//                "${month}월",
//                "${day}일",
//                when (dayOfWeek) {
//                    Calendar.SUNDAY -> "일"
//                    Calendar.MONDAY -> "월"
//                    Calendar.TUESDAY -> "화"
//                    Calendar.WEDNESDAY -> "수"
//                    Calendar.THURSDAY -> "목"
//                    Calendar.FRIDAY -> "금"
//                    Calendar.SATURDAY -> "토"
//                    else -> ""
//                }
//            ))
//        }


//        list.add(
//            CalendarDTO(
//                sYear + "년",
//                sMonth + "월",
//                (sDay.toInt() - 3).toString() + "일",
//                todayArr[4] + "요일"
//            )
//        )
//        list.add(
//            CalendarDTO(
//                sYear + "년",
//                sMonth + "월",
//                (sDay.toInt() - 2).toString() + "일",
//                todayArr[5] + "요일"
//            )
//        )
//        list.add(
//            CalendarDTO(
//                sYear + "년",
//                sMonth + "월",
//                (sDay.toInt() - 1).toString() + "일",
//                todayArr[6] + "요일"
//            )
//        )
//        list.add(CalendarDTO(sYear + "년", sMonth + "월", sDay + "일", todayArr[0] + "요일"))
//        list.add(
//            CalendarDTO(
//                sYear + "년",
//                sMonth + "월",
//                (sDay.toInt() + 1).toString() + "일",
//                todayArr[1] + "요일"
//            )
//        )
//        list.add(
//            CalendarDTO(
//                sYear + "년",
//                sMonth + "월",
//                (sDay.toInt() + 2).toString() + "일",
//                todayArr[2] + "요일"
//            )
//        )
//        list.add(
//            CalendarDTO(
//                sYear + "년",
//                sMonth + "월",
//                (sDay.toInt() + 3).toString() + "일",
//                todayArr[3] + "요일"
//            )
//        )
        adapter = ScheduleAdapter(ArrayList(list), this)
        binding.recvCalendar.adapter = adapter
        binding.recvCalendar.layoutManager = LinearLayoutManager(this)
        (binding.recvCalendar.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(
            3, // 스크롤 하고자 하는 목표 위치
            0 // 목표 아이템의 맨 위에 위치하도록 스크롤을 조정
        )

        binding.imgvBack.setOnClickListener { finish() }
    }

}