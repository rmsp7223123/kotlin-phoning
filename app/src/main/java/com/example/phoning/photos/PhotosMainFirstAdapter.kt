package com.example.phoning.photos

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.phoning.databinding.ItemGridvPhotosBinding
import com.example.phoning.dto.PhotosMainDTO
import com.example.phoning.dto.PhotosNewjeansArray
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
        binding.imgvMain.setOnClickListener {
            val intent = Intent(context, PhotosViewActivity::class.java)
            if (list[position].name == "해린 HAERIN") {
                list[position].imgSubs = PhotosNewjeansArray().imgArrayHaerin
                list[position].setIsState()
            } else if (list[position].name == "민지 MINJI") {
                list[position].imgSubs = PhotosNewjeansArray().imgArrayMinji
                list[position].setIsState()
            } else if (list[position].name == "다니엘 DANIELLE") {
                list[position].imgSubs = PhotosNewjeansArray().imgArrayDanielle
                list[position].setIsState()
            } else if (list[position].name == "하니 HANNI") {
                list[position].imgSubs = PhotosNewjeansArray().imgArrayHanni
                list[position].setIsState()
            } else if (list[position].name == "혜인 HYEIN") {
                list[position].imgSubs = PhotosNewjeansArray().imgArrayHyein
                list[position].setIsState()
            } else if (list[position].name == "NewJeans") {
                list[position].imgSubs = PhotosNewjeansArray().imgArrayNewjeans
                list[position].setIsState()
            }
            intent.putExtra("dto", list[position])
            context.startActivity(intent)
        }
        return binding.root;
    }


}