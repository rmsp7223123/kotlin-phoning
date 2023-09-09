package com.example.phoning.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.phoning.HideActionBar
import com.example.phoning.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    // lateinit 나중에 초기화 // 그렇지 않으면 오류 발생
    private lateinit var binding: ActivitySettingBinding
    //private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 초기화
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)
        binding.tvId.text = SettingCommon.user_id
        binding.tvLanguage.text = SettingCommon.setting_language
        binding.tvAlarm.text = SettingCommon.setting_alarm

        binding!!.imgvBack.setOnClickListener{
            finish()
        }

        binding.rlAlarm.setOnClickListener(View.OnClickListener {
            if(binding.tvAlarm.text.toString()==("꺼짐")) {
                Toast.makeText(this, "알람이 켜졌습니다",Toast.LENGTH_SHORT).show()
                binding.tvAlarm.text = "켜짐"
                SettingCommon.setting_alarm = "켜짐"
            }  else {
                Toast.makeText(this, "알람이 꺼졌습니다",Toast.LENGTH_SHORT).show()
                binding.tvAlarm.text = "꺼짐"
                SettingCommon.setting_alarm = "꺼짐"
            }
        })
    }
}