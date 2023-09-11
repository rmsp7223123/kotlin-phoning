package com.example.phoning.setting

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.common.SettingCommon
import com.example.phoning.databinding.ActivitySettingSubscribeBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class SettingSubscribeActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySettingSubscribeBinding

    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingSubscribeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        if (SettingCommon.subscribe == "연간") {
            binding.imgvSubscribe.setImageResource(R.drawable.setting_subscribe2)
        } else {
            binding.imgvSubscribe.setImageResource(R.drawable.setting_subscribe)
        }


        // 현재 날짜 +1달
        val currentDate = Calendar.getInstance()
        currentDate.add(Calendar.MONTH, 1)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) // Locale.getDefault() 현재 디바이스의 지역설정을 가져옴
        binding.tvUpdateDate.text = dateFormat.format(currentDate.time)


        binding.imgvBack.setOnClickListener { finish() }

        binding.tvSubscribe.setOnClickListener {
            startActivityForResult(Intent(this, SettingAlterSubscribeActivity::class.java), 0)
        }

        binding.imgvRefresh.setOnClickListener {
            finish()
            overridePendingTransition(0,0) // 인텐트 효과 없애기
            intent = getIntent()
            startActivity(intent)
            overridePendingTransition(0,0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            0 -> {
                if (resultCode == 0) {
                    // 결과 코드가 0인 경우의 처리
                    binding.imgvSubscribe.setImageResource(R.drawable.setting_subscribe)
                } else if (resultCode == 1) {
                    // 결과 코드가 1인 경우의 처리
                    binding.imgvSubscribe.setImageResource(R.drawable.setting_subscribe2)
                }
            }
        }
        binding.imgvSubscribe.invalidate()
    }
}