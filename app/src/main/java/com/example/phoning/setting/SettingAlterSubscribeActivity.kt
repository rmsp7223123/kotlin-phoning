package com.example.phoning.setting

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.common.SettingCommon
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

        binding.imgvSubscribe.setOnClickListener {
            Toast.makeText(this, getString(R.string.subscribe_month), Toast.LENGTH_SHORT).show()
            SettingCommon.subscribe = "월간"
            setResult(0)
        }

        binding.imgvSubscribe2.setOnClickListener {
            Toast.makeText(this, getString(R.string.subscribe_year), Toast.LENGTH_SHORT).show()
            SettingCommon.subscribe = "연간"
            setResult(1)
        }
    }
}