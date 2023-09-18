package com.example.phoning.message

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phoning.databinding.ItemRecvMessageChatBinding
import com.example.phoning.dto.MessageMainDTO
import com.google.firebase.database.DatabaseReference

class MessageChatAdapter(private val list: ArrayList<MessageMainDTO>, private val context: Context, private val isChatCheck: Boolean, private val databaseReference: DatabaseReference) : RecyclerView.Adapter<MessageChatAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRecvMessageChatBinding.inflate(LayoutInflater.from(parent.context), parent, false));
    };

    override fun getItemCount(): Int {
        return list.size;
    };

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    };

    inner class ViewHolder(val binding: ItemRecvMessageChatBinding) : RecyclerView.ViewHolder(binding.root);
}