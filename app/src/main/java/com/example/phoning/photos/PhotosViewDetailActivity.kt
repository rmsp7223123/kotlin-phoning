package com.example.phoning.photos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityPhotosViewDetailBinding

class PhotosViewDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPhotosViewDetailBinding;

    private var count : Int = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosViewDetailBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val hideActionBar = HideActionBar();
        hideActionBar.hideActionBar(this);

        val imgRes = intent.getIntExtra("imgres", 0);
        if (imgRes != 0) {
            binding.imgvMain.setImageResource(imgRes);
        };

        binding.imgvLike.setOnClickListener {
            if(count % 2 == 0) {
                binding.imgvLike.setImageResource(R.drawable.photos_like_empty);
            } else {
                binding.imgvLike.setImageResource(R.drawable.photos_like);
            };
            count++;
        };

        binding.imgvBack.setOnClickListener { finish(); };

    }
}