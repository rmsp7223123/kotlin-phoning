package com.example.phoning.Setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    // lateinit 나중에 초기화 // 그렇지 않으면 오류 발생
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 초기화
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)
        binding!!.imgvBack.setOnClickListener{
            finish()
        }
    }
}