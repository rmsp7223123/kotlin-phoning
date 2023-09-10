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
        binding.edtId.setText(tv_id)
        binding.tvCnt.text = "${tv_id?.length}/18"
        var hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        binding.imgvBack.setOnClickListener{
            val intent = Intent()
            intent.putExtra("test", tv_id)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.edtId.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) true else false
        }

        binding.imgvDelete.setOnClickListener {
            binding.edtId.text.clear()
        }

        binding.edtId.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                binding.tvCnt.text = "${p0.toString().length}/18"
                if (p0.toString().isEmpty()) {
                    binding.tvDone.setTextColor(Color.parseColor("#5980C3"))
                } else {
                    binding.tvDone.setTextColor(Color.parseColor("#000000"))
                    binding.tvDone.setOnClickListener {
                        val intent = Intent()
                        intent.putExtra("test", binding.edtId.text.toString())
                        setResult(RESULT_OK, intent)
                        finish()
                    }
                }

            }

        })
    }
}