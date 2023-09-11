package com.example.phoning.calls

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.databinding.ActivityCallsMainBinding
import com.example.phoning.dto.CallsMainDTO

class CallsMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCallsMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

//        val adapter = CallsMainAdapter()
//        binding.recv.apply {
//            layoutManager = LinearLayoutManager(this@CallsMainActivity)
//            this.adapter = adapter
//        }

        binding.imgvBack.setOnClickListener { finish() }

    }

    private fun callList() : ArrayList<CallsMainDTO> {
        val list = ArrayList<CallsMainDTO>()
        return list
    }
}