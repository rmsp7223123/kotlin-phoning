package com.example.phoning.photos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.phoning.databinding.ItemGridvPhotosBinding
import com.example.phoning.dto.PhotosMainDTO
import java.util.ArrayList

class PhotosMainFirstAdapter(private var inflater: LayoutInflater, private var list : ArrayList<PhotosMainDTO>, private var context : Context) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size;
    }

    override fun getItem(position: Int): Any {
        return list[position];
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemGridvPhotosBinding.inflate(
            inflater, parent, false
        );
        binding.imgvMain.setImageResource(list[position].imgRes);
        binding.tvMain.text =list[position].name;
        return binding.root;
    }


}