package com.example.phoning.photos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.databinding.ActivityPhotosViewDetailBinding

class PhotosViewDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPhotosViewDetailBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosViewDetailBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val hideActionBar = HideActionBar();
        hideActionBar.hideActionBar(this);

        binding.imgvBack.setOnClickListener { finish(); };

        val imgRes = intent.getIntExtra("imgres", 0);
        if (imgRes != 0) {
            binding.imgvMain.setImageResource(imgRes);
        };
    }
}