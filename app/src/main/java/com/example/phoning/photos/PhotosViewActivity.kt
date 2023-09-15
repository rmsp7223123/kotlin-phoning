package com.example.phoning.photos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityPhotosViewBinding
import com.example.phoning.dto.PhotosMainDTO

class PhotosViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPhotosViewBinding;

    private var dto: PhotosMainDTO? = null;

    var gridvAdapter: PhotosViewAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosViewBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val hideActionBar = HideActionBar();
        hideActionBar.hideActionBar(this);
        dto = intent.getSerializableExtra("dto") as? PhotosMainDTO;
        gridvAdapter = PhotosViewAdapter(layoutInflater, dto!!, this);
        binding.gridv.adapter = gridvAdapter;
        binding.name.text = dto!!.name;

        binding.imgvBack.setOnClickListener { finish(); };
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 1000) {
            dto = data!!.getSerializableExtra("dto") as PhotosMainDTO?
            gridvAdapter!!.dto = dto!!;
            gridvAdapter!!.notifyDataSetChanged();
        };
    }
}