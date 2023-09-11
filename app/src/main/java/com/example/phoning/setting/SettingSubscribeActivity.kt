package com.example.phoning.setting

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.common.CommonVar
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

        if (CommonVar.loginInfo?.subscribe == "y") {
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
            intent = Intent(this, SettingAlterSubscribeActivity::class.java)
            startActivity(intent)
        }

        binding.imgvRefresh.setOnClickListener {
            finish()
            overridePendingTransition(0,0) // 인텐트 효과 없애기
            intent = getIntent()
            startActivity(intent)
            overridePendingTransition(0,0)
        }
    }
}