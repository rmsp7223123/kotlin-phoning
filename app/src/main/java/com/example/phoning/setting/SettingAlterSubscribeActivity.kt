package com.example.phoning.setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.databinding.ActivitySettingAlterSubscribeBinding

class SettingAlterSubscribeActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingAlterSubscribeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingAlterSubscribeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        binding.imgvBack.setOnClickListener { finish() }
    }
}