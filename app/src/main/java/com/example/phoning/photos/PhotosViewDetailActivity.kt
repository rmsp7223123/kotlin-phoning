package com.example.phoning.photos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.common.PhotosCommon
import com.example.phoning.common.PhotosCommon.imgRes
import com.example.phoning.databinding.ActivityPhotosViewDetailBinding
import com.example.phoning.dto.PhotosMainDTO

class PhotosViewDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPhotosViewDetailBinding;

    private var count = 1;

    private lateinit var adapter : PhotosViewAdapter;

    private var dto: PhotosMainDTO? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosViewDetailBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val hideActionBar = HideActionBar();
        hideActionBar.hideActionBar(this);

        if(imgRes == null) {
            imgRes = ArrayList();
            PhotosCommon.likeBoolean = HashMap();
        };

        dto = intent.getSerializableExtra("dto") as? PhotosMainDTO;
        adapter = PhotosViewAdapter(layoutInflater, dto!!, PhotosViewActivity());

        val imgRes = intent.getIntExtra("imgres", 0);
        val imgKey = imgRes.toString();
        val isLiked = PhotosCommon.likeBoolean?.get(imgKey) ?: false
        if (imgRes != 0) {
            binding.imgvMain.setImageResource(imgRes);
        };

//        if (PhotosCommon.likeBoolean!![cnt]) {
//            binding.imgvLike.setImageResource(R.drawable.photos_like);
//            count = 2;
//        } else {
//            binding.imgvLike.setImageResource(R.drawable.photos_like_empty);
//            count = 1;
//        }

//        if (PhotosCommon.likeBoolean?.getOrNull(cnt) == true) {
//            binding.imgvLike.setImageResource(R.drawable.photos_like)
//            count = 2
//        } else {
//            binding.imgvLike.setImageResource(R.drawable.photos_like_empty)
//            count = 1
//        }

        if (isLiked) {
            binding.imgvLike.setImageResource(R.drawable.photos_like);
            count = 2;
        } else {
            binding.imgvLike.setImageResource(R.drawable.photos_like_empty);
            count = 1;
        };


        binding.imgvLike.setOnClickListener {
            if(count % 2 == 0) {
                binding.imgvLike.setImageResource(R.drawable.photos_like_empty)
                PhotosCommon.imgRes?.remove(imgRes);
                PhotosCommon.likeBoolean?.put(imgKey, false);
            } else {
                binding.imgvLike.setImageResource(R.drawable.photos_like)
                PhotosCommon.imgRes?.add(imgRes);
                PhotosCommon.likeBoolean?.put(imgKey, true);
            }
            adapter.notifyDataSetChanged();
        };

        binding.imgvBack.setOnClickListener { finish(); };

    }
}