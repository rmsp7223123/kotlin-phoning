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

class PhotosMainSecondAdapter(private var inflater: LayoutInflater, private var list : ArrayList<PhotosMainDTO>, private var context : Context) : BaseAdapter() {
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
            if (list[position].name == "\uD83D\uDC30 \uD83D\uDCF7") {
                list[position].imgSubs = PhotosNewjeansArray().imgArrayCamera;
                list[position].setIsState();
            } else if (list[position].name == "\uD83D\uDC30 ✏️") {
                list[position].imgSubs= PhotosNewjeansArray().imgArrayPen;
                list[position].setIsState();
            } else if (list[position].name == "\uD83D\uDC30 \uD83C\uDF15") {
                list[position].imgSubs =PhotosNewjeansArray().imgArrayMoon;
                list[position].setIsState();
            } else if (list[position].name == "NewJeans Day") {
                list[position].imgSubs = PhotosNewjeansArray().imgArrayNewJeansDay;
                list[position].setIsState();
            }
            intent.putExtra("dto", list[position]);
            context.startActivity(intent);
        }
        return binding.root;
    }
}