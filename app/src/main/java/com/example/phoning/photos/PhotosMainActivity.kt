package com.example.phoning.photos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityPhotosMainBinding
import com.example.phoning.dto.PhotosMainDTO

class PhotosMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPhotosMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val hideActionBar = HideActionBar();
        hideActionBar.hideActionBar(this);
        binding.gridv.adapter = PhotosMainFirstAdapter(layoutInflater, getlist(), this);
        binding.gridv2.adapter = PhotosMainFirstAdapter(layoutInflater, getlist(), this);
        binding.imgvBack.setOnClickListener { finish() };
    }

    fun getlist(): ArrayList<PhotosMainDTO> {
        val list = ArrayList<PhotosMainDTO>();
        list.add(PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN"));
        list.add(PhotosMainDTO(R.drawable.minji1, "민지 MINJI"));
        list.add(PhotosMainDTO(R.drawable.danielle1, "다니엘 DANIELLE"));
        list.add(PhotosMainDTO(R.drawable.hanni1, "하니 HANNI"));
        list.add(PhotosMainDTO(R.drawable.hyein1, "혜인 HYEIN"));
        list.add(PhotosMainDTO(R.drawable.newjeans1, "NewJeans"));
        return list
    };
}