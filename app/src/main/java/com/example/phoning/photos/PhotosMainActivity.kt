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
        binding.gridv.adapter = PhotosMainFirstAdapter(layoutInflater, getFirstList(), this);
        binding.gridv2.adapter = PhotosMainSecondAdapter(layoutInflater, getSecndList(), this);
        binding.imgvBack.setOnClickListener { finish() };
    }

    fun getFirstList(): ArrayList<PhotosMainDTO> {
        val list = ArrayList<PhotosMainDTO>();
        list.add(PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN"));
        list.add(PhotosMainDTO(R.drawable.minji1, "민지 MINJI"));
        list.add(PhotosMainDTO(R.drawable.danielle1, "다니엘 DANIELLE"));
        list.add(PhotosMainDTO(R.drawable.hanni1, "하니 HANNI"));
        list.add(PhotosMainDTO(R.drawable.hyein1, "혜인 HYEIN"));
        list.add(PhotosMainDTO(R.drawable.newjeans1, "NewJeans"));
        return list
    };

    fun getSecndList(): ArrayList<PhotosMainDTO> {
        val list = ArrayList<PhotosMainDTO>();
        list.add(PhotosMainDTO(R.drawable.photo_camera1, "\uD83D\uDC30 \uD83D\uDCF7"));
        list.add(PhotosMainDTO(R.drawable.photo_pen1, "\uD83D\uDC30 ✏️"));
        list.add(PhotosMainDTO(R.drawable.photo_moon1, "\uD83D\uDC30 \uD83C\uDF15"));
        list.add(PhotosMainDTO(R.drawable.photo_newjeansday1, "NewJeans Day"));
        return list;
    };
}