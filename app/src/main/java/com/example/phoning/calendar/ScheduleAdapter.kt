package com.example.phoning.calendar

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phoning.R
import com.example.phoning.databinding.ItemRecvCalendarBinding
import com.example.phoning.databinding.ItemRecvScheduleBinding
import com.example.phoning.dto.CalendarDTO
import com.example.phoning.dto.ScheduleDTO


class ScheduleAdapter(var list : ArrayList<CalendarDTO>, var context: Context) : RecyclerView.Adapter<ScheduleAdapter.ViewHolderParent>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderParent {
        return ViewHolderParent(ItemRecvCalendarBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderParent, position: Int) {
        holder.binding.tvYear.text = list[position].year
        holder.binding.tvMonth.text = list[position].month
        holder.binding.tvDate.text = list[position].day
        holder.binding.tvDay.text = list[position].date
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            holder.binding.rlToday.focusable
        }
        val list = ArrayList<ScheduleDTO>()
        list.add(
            ScheduleDTO(
                R.drawable.calendar_newjeans,
                "NewJeans",
                "🎬 'New Jeans' MV'",
                "891",
                "오전12:00"
            )
        )
        list.add(
            ScheduleDTO(
                R.drawable.calendar_newjeans,
                "NewJeans",
                "🎵 2nd EP 'Get Up' 음원 선공개",
                "432",
                "오후1:00"
            )
        )
        list.add(
            ScheduleDTO(
                R.drawable.calendar_newjeans,
                "NewJeans",
                "🎬 'Super Shy' MV",
                "285",
                "오후1:00"
            )
        )
        list.add(
            ScheduleDTO(
                R.drawable.calendar_hanni,
                "하니_hanni_:)",
                "🔪🔪🔪🔪🔪",
                "445",
                "오전12:00~오후11:59"
            )
        )
        holder.binding.recvSchedule.adapter = ChlidAdapter(list, context)
        holder.binding.recvSchedule.layoutManager = LinearLayoutManager(context)
    }

    inner class ViewHolderParent(var binding: ItemRecvCalendarBinding) : RecyclerView.ViewHolder(
        binding.root
    )

    inner class ChlidAdapter(var list: ArrayList<ScheduleDTO>, var context: Context) :
        RecyclerView.Adapter<ChlidAdapter.ViewHolderChild>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderChild {
            return ViewHolderChild(
                ItemRecvScheduleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(h: ViewHolderChild, i: Int) {
            h.binding.imgvProfile.setImageResource(list[i].imgv_profile)
            h.binding.tvWriter.text = list[i].tv_writer
            h.binding.tvTitle.text = list[i].tv_title
            h.binding.tvChat.text = list[i].tv_chat
            h.binding.tvTime.text = list[i].tv_time
            if (list[i].tv_writer == "NewJeans") {
                h.binding.lnBg.setBackgroundResource(R.drawable.border_radius4)
            } else {
                h.binding.lnBg.setBackgroundResource(R.drawable.border_radius3)
            }
        }

        override fun getItemCount(): Int {
            return list.size
        }

        inner class ViewHolderChild(var binding: ItemRecvScheduleBinding) : RecyclerView.ViewHolder(
            binding.root
        )
    }
}