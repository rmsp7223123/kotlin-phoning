package com.example.phoning.message

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.phoning.R
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
        val chatDTO = list[position];
        holder.binding.tvName.text = chatDTO.name
        holder.binding.imgvMain.setImageResource(chatDTO.imgRes)

        holder.binding.containerFrame.removeAllViews()
        val tvMsg = TextView(context)
        val tvTime = TextView(context)
        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val params2 = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        if (chatDTO.isCheck) {
            holder.binding.containerFrame.layoutParams = params2
            holder.binding.tvName.visibility = View.GONE
            holder.binding.imgvMain.visibility = View.GONE
            holder.binding.cVMain.visibility = View.GONE
            params2.gravity = Gravity.END
            tvMsg.text = chatDTO.content
            tvMsg.setTextColor(Color.parseColor("#000000"))
            tvMsg.textSize = 16f
            tvMsg.setBackgroundResource(R.drawable.message_chat_me_background)
            tvMsg.setPadding(30, 20, 70, 20)
            tvMsg.maxWidth = 800
            params.gravity = Gravity.BOTTOM or Gravity.END
            params.setMargins(0, 0, 20, 0)
            tvTime.layoutParams = params
            tvTime.text = chatDTO.date
            tvTime.setTextColor(Color.parseColor("#000000"))
            tvTime.textSize = 12f
            holder.binding.containerFrame.addView(tvTime)
            holder.binding.containerFrame.addView(tvMsg)
        } else {
            tvMsg.text = chatDTO.content
            tvMsg.setTextColor(Color.parseColor("#000000"))
            tvMsg.textSize = 16f
            tvMsg.setBackgroundResource(R.drawable.message_chat_background)
            tvMsg.setPadding(30, 20, 70, 20)
            tvMsg.maxWidth = 800
            params.gravity = Gravity.BOTTOM or Gravity.START
            tvTime.layoutParams = params
            tvTime.text = chatDTO.date
            tvTime.setTextColor(Color.parseColor("#000000"))
            tvTime.textSize = 12f
            holder.binding.containerFrame.addView(tvMsg)
            holder.binding.containerFrame.addView(tvTime)
        };
    };

    inner class ViewHolder(val binding: ItemRecvMessageChatBinding) : RecyclerView.ViewHolder(binding.root);

    fun addData(chatDTO: MessageMainDTO) {
        list.add(chatDTO);
        notifyDataSetChanged();
    };

    fun removeData(chatDTO: MessageMainDTO) {
        list.remove(chatDTO);
        notifyDataSetChanged();
    };
}