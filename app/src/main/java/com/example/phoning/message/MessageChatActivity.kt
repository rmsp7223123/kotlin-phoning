package com.example.phoning.message

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityMessageChatBinding

class MessageChatActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMessageChatBinding;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageChatBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val hideActionBar = HideActionBar();
        hideActionBar.hideActionBar(this);
    }
}