package com.example.phoning.photos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.common.PhotosCommon
import com.example.phoning.databinding.ActivityPhotosGalleryBinding

class PhotosGalleryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPhotosGalleryBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosGalleryBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val hideActionBar = HideActionBar();
        hideActionBar.hideActionBar(this);

        if(PhotosCommon.imgRes?.size != 0) {
            binding.girdv.adapter = PhotosGalleryAdapter(layoutInflater, PhotosCommon.imgRes, this);
        };

        binding.imgvBack.setOnClickListener { finish(); };
    };
}