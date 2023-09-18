package com.example.phoning.photos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityPhotosViewBinding
import com.example.phoning.dto.PhotosMainDTO

class PhotosViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPhotosViewBinding;

    private var dto: PhotosMainDTO? = null;

    var gridvAdapter: PhotosViewAdapter? = null;

    private val layoutManager : LinearLayoutManager? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosViewBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val hideActionBar = HideActionBar();
        hideActionBar.hideActionBar(this);
        dto = intent.getSerializableExtra("dto") as? PhotosMainDTO;
        gridvAdapter = PhotosViewAdapter(layoutInflater, dto!!, this);
        binding.gridv.adapter = gridvAdapter;
        binding.tvName.text = dto!!.name;

        binding.imgvBack.setOnClickListener { finish(); };

        binding.imgvSort.setOnClickListener {
            dto!!.imgSubs!!.reverse();
            gridvAdapter!!.notifyDataSetChanged();
        };
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 1000) {
            dto = data!!.getSerializableExtra("dto") as PhotosMainDTO?
            gridvAdapter!!.dto = dto!!;
        };
        gridvAdapter!!.notifyDataSetChanged();
    };


}