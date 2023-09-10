package com.example.phoning.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoning.R
import com.example.phoning.databinding.ActivitySettingLanguageBinding

class SettingLanguageActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingLanguageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvBack.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("language", SettingCommon.setting_language)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}