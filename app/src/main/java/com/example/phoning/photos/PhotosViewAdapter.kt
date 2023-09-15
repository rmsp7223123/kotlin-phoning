package com.example.phoning.photos

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.phoning.R
import com.example.phoning.databinding.ItemGridvPhotosviewBinding
import com.example.phoning.dto.PhotosMainDTO

class PhotosViewAdapter(
    var inflater: LayoutInflater,
    var dto: PhotosMainDTO,
    var context: PhotosViewActivity
) : BaseAdapter() {
    override fun getCount(): Int {
        return dto.imgSubs!!.size;
    }

    override fun getItem(position: Int): Any {
        return position;
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemGridvPhotosviewBinding.inflate(
            inflater, parent, false
        );
//        if (dto.getIsState().get(position) === true) {
//            binding.imgvLike.setImageResource(R.drawable.photos_like)
//        } else {
//            binding.imgvLike.setImageResource(0)
//        }
        binding.imgvPhoto.setImageResource(dto.imgSubs!![position]);
        binding.imgvPhoto.setOnClickListener {
            val intent = Intent(context, PhotosViewDetailActivity::class.java)
            intent.putExtra("imgres", dto.imgSubs!![position])
            intent.putExtra("dto", dto)
            intent.putExtra("count", position)
            context.startActivityForResult(intent, 1000)
        }
        return binding.root;
    }
}