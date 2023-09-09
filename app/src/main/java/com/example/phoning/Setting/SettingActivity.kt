package com.example.phoning.Setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {

    private var mBinding : ActivitySettingBinding? = null
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

    }
}