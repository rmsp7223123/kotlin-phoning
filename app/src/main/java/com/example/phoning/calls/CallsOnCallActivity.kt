package com.example.phoning.calls

import android.content.Intent
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.dto.CallInfo
import com.example.phoning.databinding.ActivityCallsOnCallBinding

class CallsOnCallActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCallsOnCallBinding
    private lateinit var fragmentManager: FragmentManager
    private var imgcnt = 1
    private var zoomCount = 1
    private var savedProgress = 0
    private var taskProgress = 0
    private var seekBarTask: AsyncTask<Void, Int, Void>? = null

    private val callData = mapOf(
        "2023.6.27 16:10" to CallInfo(R.drawable.calls_danielle2, "다니엘_Danielle\uD83C\uDF3B", "00:37:46"),
        "2023.6.16 14:05" to CallInfo(R.drawable.calls_minji2, "민지Minji\uD83E\uDDF8", "00:38:00"),
        "2023.5.17 18:30" to CallInfo(R.drawable.calls_newjeans2, "NewJeans\uD83D\uDC56", "00:29:05"),
        "2023.4.27 21:11" to CallInfo(R.drawable.calls_hyein2, "혜인:)Hyein\uD83D\uDC23", "00:37:46"),
        "2023.4.5 13:15" to CallInfo(R.drawable.calls_hanni2, "하니_hanni_:)", "00:51:34"),
        "2023.3.27 15:05" to CallInfo(R.drawable.calls_haerin2, "해린_haerin", "00:26:20"),
        "2023.3.25 12:57" to CallInfo(R.drawable.calls_hyein2, "혜인:)Hyein\uD83D\uDC23", "00:07:14"),
        "2023.3.25 11:34" to CallInfo(R.drawable.calls_minji2, "민지Minji\uD83E\uDDF8", "00:45:45")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallsOnCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startSeekBar()

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        fragmentManager = supportFragmentManager

        var callDate = intent.getStringExtra("call_date")

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

        setCallInfo(callDate)

//        when (callDate) {
//            "2023.6.27 16:10" -> {
//                binding.containerBackground.setBackgroundResource(R.drawable.calls_danielle2)
//                binding.tvName.text = "다니엘_Danielle\uD83C\uDF3B"
//                binding.tvCallTotaltime.text = "00:37:46"
//            }
//            "2023.6.16 14:05" -> {
//                binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2)
//                binding.tvName.text = "민지Minji\uD83E\uDDF8"
//                binding.tvCallTotaltime.text = "00:38:00"
//            }
//            "2023.5.17 18:30" -> {
//                binding.containerBackground.setBackgroundResource(R.drawable.calls_newjeans2)
//                binding.tvName.text = "NewJeans\uD83D\uDC56"
//                binding.tvCallTotaltime.text = "00:29:05"
//            }
//            "2023.4.27 21:11" -> {
//                binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2)
//                binding.tvName.text = "혜인:)Hyein\uD83D\uDC23"
//                binding.tvCallTotaltime.text = "00:37:46"
//            }
//            "2023.4.5 13:15" -> {
//                binding.containerBackground.setBackgroundResource(R.drawable.calls_hanni2)
//                binding.tvName.text = "하니_hanni_:)"
//                binding.tvCallTotaltime.text = "00:51:34"
//            }
//            "2023.3.27 15:05" -> {
//                binding.containerBackground.setBackgroundResource(R.drawable.calls_haerin2)
//                binding.tvName.text = "해린_haerin"
//                binding.tvCallTotaltime.text = "00:26:20"
//            }
//            "2023.3.25 12:57" -> {
//                binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2)
//                binding.tvName.text = "혜인:)Hyein\uD83D\uDC23"
//                binding.tvCallTotaltime.text = "00:07:14"
//            }
//            "2023.3.25 11:34" -> {
//                binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2)
//                binding.tvName.text = "민지Minji\uD83E\uDDF8"
//                binding.tvCallTotaltime.text = "00:45:45"
//            }
//        }

        binding.imgvSub.setOnClickListener {
            val dlgView = LayoutInflater.from(this@CallsOnCallActivity).inflate(R.layout.dialog_calls_on_call, null)
            val dlg = AlertDialog.Builder(this@CallsOnCallActivity)
                .setView(dlgView)
                .create()

            dlg.window?.setGravity(Gravity.BOTTOM)

            val containerFrame = dlgView.findViewById<FrameLayout>(R.id.container_frame)
            val tvResolution = dlgView.findViewById<TextView>(R.id.tv_resolution)

            containerFrame.setOnClickListener {
                val dlgDetailView = LayoutInflater.from(this@CallsOnCallActivity).inflate(R.layout.dialog_detail_call_on_call, null)
                val containerFrameAuto = dlgDetailView.findViewById<FrameLayout>(R.id.container_frame_auto)
                val containerFrame720p = dlgDetailView.findViewById<FrameLayout>(R.id.container_frame_720p)
                val containerFrame480p = dlgDetailView.findViewById<FrameLayout>(R.id.container_frame_480p)
                val containerFrame360p = dlgDetailView.findViewById<FrameLayout>(R.id.container_frame_360p)
                val containerFrame160p = dlgDetailView.findViewById<FrameLayout>(R.id.container_frame_160p)

                val dialogDetail = AlertDialog.Builder(this@CallsOnCallActivity)
                    .setView(dlgDetailView)
                    .create()

                dialogSetting(dlgDetailView.findViewById(R.id.tv_auto), dlgDetailView.findViewById(R.id.imgv_check_auto))
                tvResolution.text = "자동"

                containerFrameAuto.setOnClickListener {
                    dialogSetting(dlgDetailView.findViewById(R.id.tv_auto), dlgDetailView.findViewById(R.id.imgv_check_auto))
                    tvResolution.text = "자동"
                    dialogDetail.dismiss()
                }

                containerFrame720p.setOnClickListener {
                    dialogSetting(dlgDetailView.findViewById(R.id.tv_720p), dlgDetailView.findViewById(R.id.imgv_check_720p))
                    tvResolution.text = "720p"
                    dialogDetail.dismiss()
                }

                containerFrame480p.setOnClickListener {
                    dialogSetting(dlgDetailView.findViewById(R.id.tv_480p), dlgDetailView.findViewById(R.id.imgv_check_480p))
                    tvResolution.text = "480p"
                    dialogDetail.dismiss()
                }

                containerFrame360p.setOnClickListener {
                    dialogSetting(dlgDetailView.findViewById(R.id.tv_360p), dlgDetailView.findViewById(R.id.imgv_check_360p))
                    tvResolution.text = "360p"
                    dialogDetail.dismiss()
                }

                containerFrame160p.setOnClickListener {
                    dialogSetting(dlgDetailView.findViewById(R.id.tv_160p), dlgDetailView.findViewById(R.id.imgv_check_160p))
                    tvResolution.text = "160p"
                    dialogDetail.dismiss()
                }

                dialogDetail.show()
            }

            dlg.show()
        }

        binding.imgvCalloff.setOnClickListener {
            val intent = Intent(this, CallsCallOffSplashActivity::class.java)
            intent.putExtra("call_date", callDate)
            startActivity(intent)
            finish()
        }

        binding.containerCall.visibility = View.INVISIBLE

        binding.containerBackground.setOnClickListener {
            binding.containerCall.visibility = if (binding.containerCall.visibility == View.INVISIBLE) View.VISIBLE else View.INVISIBLE
//            if (binding.containerCall.visibility == View.INVISIBLE) {
//                binding.containerCall.visibility = View.VISIBLE
//            } else {
//                binding.containerCall.visibility = View.INVISIBLE
//            }
        }

        binding.sbTimer.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                savedProgress = progress
                if (fromUser) {
                    taskProgress = progress
                }
                val hours = progress / 3600
                val minutes = progress % 3600 / 60
                val seconds = progress % 60

                val timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds)
                binding.tvTime.text = timeString
                binding.tvTime2.text = timeString
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        binding.btnPlay.setOnClickListener {
            if (imgcnt % 2 == 1) {
                binding.btnPlay.setImageResource(R.drawable.calls_play)
                stopSeekBar()
            } else {
                binding.btnPlay.setImageResource(R.drawable.calls_stop)
                startSeekBar()
            }
            imgcnt++
        }
    }

    private fun startSeekBar() {
        val callDate = intent.getStringExtra("call_date")
        var calltime = 0

        when (callDate) {
            "2023.6.27 16:10" -> calltime = 2266
            "2023.6.16 14:05" -> calltime = 2280
            "2023.5.17 18:30" -> calltime = 1745
            "2023.4.27 21:11" -> calltime = 2266
            "2023.4.5 13:15" -> calltime = 3094
            "2023.3.27 15:05" -> calltime = 1580
            "2023.3.25 12:57" -> calltime = 434
            "2023.3.25 11:34" -> calltime = 2745
        }

        val calltime2 = calltime

        binding.sbTimer.max = calltime2
        binding.sbTimer.isEnabled = true

        if (savedProgress == 0) {
            binding.sbTimer.progress = 0
        } else {
            binding.sbTimer.progress = savedProgress
        }

        seekBarTask?.cancel(true)

        seekBarTask = object : AsyncTask<Void, Int, Void>() {
            override fun doInBackground(vararg params: Void): Void? {
                for (taskProgress in binding.sbTimer.progress until calltime2) {
                    if (isCancelled) {
                        break
                    }
                    try {
                        Thread.sleep(1000)
                        publishProgress(savedProgress)
                        savedProgress = taskProgress
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                return null
            }

            override fun onProgressUpdate(vararg values: Int?) {
                binding.sbTimer.progress = savedProgress
            }
        }

        seekBarTask?.execute()
    }

    private fun stopSeekBar() {
        seekBarTask?.cancel(true)
        binding.sbTimer.isEnabled = false
    }

    private fun dialogSetting(tvName: TextView, imgvName: ImageView) {
        val dlgDetailView = LayoutInflater.from(this@CallsOnCallActivity).inflate(R.layout.dialog_detail_call_on_call, null)
        val tvAuto = dlgDetailView.findViewById<TextView>(R.id.tv_auto)
        val tv720p = dlgDetailView.findViewById<TextView>(R.id.tv_720p)
        val tv480p = dlgDetailView.findViewById<TextView>(R.id.tv_480p)
        val tv360p = dlgDetailView.findViewById<TextView>(R.id.tv_360p)
        val tv160p = dlgDetailView.findViewById<TextView>(R.id.tv_160p)
        val imgvCheckAuto = dlgDetailView.findViewById<ImageView>(R.id.imgv_check_auto)
        val imgvCheck720p = dlgDetailView.findViewById<ImageView>(R.id.imgv_check_720p)
        val imgvCheck480p = dlgDetailView.findViewById<ImageView>(R.id.imgv_check_480p)
        val imgvCheck360p = dlgDetailView.findViewById<ImageView>(R.id.imgv_check_360p)
        val imgvCheck160p = dlgDetailView.findViewById<ImageView>(R.id.imgv_check_160p)

        imgvCheckAuto.visibility = View.INVISIBLE
        imgvCheck720p.visibility = View.INVISIBLE
        imgvCheck480p.visibility = View.INVISIBLE
        imgvCheck360p.visibility = View.INVISIBLE
        imgvCheck160p.visibility = View.INVISIBLE
        tvAuto.setTextColor(Color.parseColor("#000000"))
        tv720p.setTextColor(Color.parseColor("#000000"))
        tv480p.setTextColor(Color.parseColor("#000000"))
        tv360p.setTextColor(Color.parseColor("#000000"))
        tv160p.setTextColor(Color.parseColor("#000000"))

        tvName.setTextColor(Color.parseColor("#6598EE"))
        imgvName.visibility = View.VISIBLE
    }

    private fun setCallInfo(callDate: String?) {
        val callInfo = callData[callDate]
        if (callInfo != null) {
            binding.containerBackground.setBackgroundResource(callInfo.backgroundResource)
            binding.tvName.text = callInfo.name
            binding.tvCallTotaltime.text = callInfo.totalTime
        }
    }
}