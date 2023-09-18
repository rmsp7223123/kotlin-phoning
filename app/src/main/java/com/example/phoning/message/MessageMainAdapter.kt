package com.example.phoning.message

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phoning.databinding.ItemRecvMessageBinding
import com.example.phoning.dto.MessageMainDTO

class MessageMainAdapter(private val context: Context, private val list: ArrayList<MessageMainDTO>) :
    RecyclerView.Adapter<MessageMainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecvMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false);
        return ViewHolder(binding);
    };

    override fun getItemCount(): Int {
        return list.size;
    };

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    };

    inner class ViewHolder(val binding: ItemRecvMessageBinding) : RecyclerView.ViewHolder(binding.root);
}