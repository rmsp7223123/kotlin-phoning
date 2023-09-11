package com.example.phoning.setting

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    // lateinit 나중에 초기화 // 그렇지 않으면 오류 발생
    private lateinit var binding: ActivitySettingBinding
    //private lateinit var intent: Intent
    private lateinit var intent: Intent

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

        binding.imgvBack.setOnClickListener{
            finish()
        }

        binding.tvEditId.setOnClickListener {
            intent = Intent(this, SettingEditIdActivity::class.java)
            intent.putExtra("tv_id", binding.tvId.text.toString())
            startActivityForResult(intent , 0)
        }

        binding.rlAlarm.setOnClickListener(View.OnClickListener {
            toggleAlarm()
        })

        binding.rlLanguage.setOnClickListener {
            intent = Intent(this, SettingLanguageActivity::class.java)
            startActivityForResult(intent,1)
        }

    }






    private fun toggleAlarm() {
        if(binding.tvAlarm.text.toString()==("꺼짐")) {
            Toast.makeText(this, getString(R.string.alarm_on),Toast.LENGTH_SHORT).show()
            binding.tvAlarm.text = "켜짐"
            SettingCommon.setting_alarm = "켜짐"
        }  else {
            Toast.makeText(this, getString(R.string.alarm_off),Toast.LENGTH_SHORT).show()
            binding.tvAlarm.text = "꺼짐"
            SettingCommon.setting_alarm = "꺼짐"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            0 -> {
                if (resultCode == RESULT_OK) {
                    val test = data?.getStringExtra("test")
                    binding.tvId.text = test
                    SettingCommon.user_id = test ?: ""
                    // test가 null이면 "" / 아니면 test
                }
            }

            1 -> {
                if (resultCode == RESULT_OK) {
                    val language = data?.getStringExtra("language")
                    binding.tvLanguage.text = language
                    SettingCommon.setting_language = language ?: ""
                }
            }
        }
    }
}