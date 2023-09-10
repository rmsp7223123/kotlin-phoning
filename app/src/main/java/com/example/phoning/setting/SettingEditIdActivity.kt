package com.example.phoning.setting

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivitySettingEditIdBinding

class SettingEditIdActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySettingEditIdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingEditIdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tv_id = intent.getStringExtra("tv_id")
        val maxLength = 18
        binding.edtId.setText(tv_id)
        binding.tvCnt.text = getString(R.string.char_count, tv_id?.length, maxLength)
        var hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        binding.imgvBack.setOnClickListener{
            val resultIntent = Intent()
            resultIntent.putExtra("test", tv_id)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        binding.edtId.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) true else false
            // 엔터키를 눌렀을때만 true를 반환
        }

        binding.imgvDelete.setOnClickListener {
            binding.edtId.text.clear()
        }

        binding.edtId.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val inputLength = p0.toString().length
                // EditText에 입력된 문자열의 길이를 계산
                binding.tvCnt.text = getString(R.string.char_count, inputLength, maxLength)
                // tvCnt = 문자 수: 현재 입력된 길이 / 최대 길이

                val textColor = if (inputLength > 0) Color.parseColor("#000000") else Color.parseColor("#5980C3")
                binding.tvDone.setTextColor(textColor)

                binding.tvDone.setOnClickListener {
                    val resultIntent = Intent()
                    resultIntent.putExtra("test", binding.edtId.text.toString())
                    setResult(RESULT_OK, resultIntent)
                    finish()
                }

            }

        })
    }
}