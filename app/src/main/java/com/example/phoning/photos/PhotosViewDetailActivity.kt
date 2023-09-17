package com.example.phoning.photos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.common.PhotosCommon
import com.example.phoning.databinding.ActivityPhotosViewDetailBinding
import com.example.phoning.dto.PhotosMainDTO

class PhotosViewDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPhotosViewDetailBinding;

    private var count : Int = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosViewDetailBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val hideActionBar = HideActionBar();
        hideActionBar.hideActionBar(this);

        val cnt = intent.getIntExtra("count", 0);

        if (PhotosCommon.IsLike[cnt]) {
            binding.imgvLike.setImageResource(R.drawable.photos_like);
            count = 2;
        };

        val imgRes = intent.getIntExtra("imgres", 0);
        if (imgRes != 0) {
            binding.imgvMain.setImageResource(imgRes);
        };

        if(PhotosCommon.imgRes == null) PhotosCommon.imgRes = ArrayList();

        binding.imgvLike.setOnClickListener {
            if(count % 2 == 0) {
                binding.imgvLike.setImageResource(R.drawable.photos_like_empty);
                PhotosCommon.IsLike[cnt] = false;
                PhotosCommon.imgRes?.remove(imgRes);
            } else {
                binding.imgvLike.setImageResource(R.drawable.photos_like);
                PhotosCommon.IsLike[cnt] = true;
                PhotosCommon.imgRes?.add(imgRes);
            };
            count++;
        };

        binding.imgvBack.setOnClickListener { finish(); };

    }
}