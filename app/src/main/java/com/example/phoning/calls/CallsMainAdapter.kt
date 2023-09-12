package com.example.phoning.calls

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phoning.R
import com.example.phoning.common.CallsCommon
import com.example.phoning.databinding.ItemRecvCallsBinding
import com.example.phoning.dto.CallsMainDTO

class CallsMainAdapter(var list: ArrayList<CallsMainDTO>, var context : Context, var isCheckCall : Boolean) : RecyclerView.Adapter<CallsMainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRecvCallsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgvNewjeans.setImageResource(list[position].newjeansimg)
        holder.binding.callCheck.setImageResource(list[position].callCheck)
        holder.binding.tvName.text = list[position].name
        holder.binding.tvCallTime.text = list[position].callTime
        holder.binding.callDate.text = list[position].callDate
        if (list[position].isCheck) holder.binding.callCheck.setImageResource(R.drawable.calls_callcheck)

        holder.binding.containerRelative.setOnClickListener {
            CallsCommon.IsCheck[position] = true
            list[position].isCheck = CallsCommon.IsCheck[position]
            val intent = Intent(context, CallsSplashActivity::class.java)
            intent.putExtra("call_date", list[position].callDate)
            context.startActivity(intent)
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(var binding : ItemRecvCallsBinding) : RecyclerView.ViewHolder(
        binding.root
    )
}