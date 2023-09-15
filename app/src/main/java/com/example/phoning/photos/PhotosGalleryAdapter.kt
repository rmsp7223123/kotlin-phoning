package com.example.phoning.photos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.phoning.common.PhotosCommon
import com.example.phoning.databinding.ItemGridvPhotosBinding
import com.example.phoning.databinding.ItemGridvPhotosviewBinding
import com.example.phoning.dto.PhotosMainDTO

class PhotosGalleryAdapter(var inflater: LayoutInflater, var list: ArrayList<Int>?, var context: PhotosGalleryActivity) : BaseAdapter() {
    override fun getCount(): Int {
        return list?.size ?: 0
    };

    override fun getItem(position: Int): Any {
        return position;
    };

    override fun getItemId(position: Int): Long {
        return position.toLong();
    };

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemGridvPhotosviewBinding.inflate(
            inflater, parent, false
        );
        if(PhotosCommon.imgRes?.size != 0) {
            binding.imgvPhoto.setImageResource(PhotosCommon.imgRes!![position]);
        }
        return binding.root;
    };
}