package com.example.phoning.setting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phoning.databinding.ItemSettingLanguageRecvBinding

class SettingLanguageAdapter(private var list: ArrayList<LanguageDTO>) :
    RecyclerView.Adapter<SettingLanguageAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSettingLanguageRecvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.radio.text = list[position].tv_lg
        holder.binding.radio.isChecked =list[position].isChecked
        for (j in list.indices) {
            list[j].isChecked = false
            list[j] = LanguageDTO(false, list[j].tv_lg)
        }
        list[position].isChecked = true
        list[position] = LanguageDTO(true, list[position].tv_lg)
        notifyDataSetChanged()
    }

    // 내부 클래스에서는 외부 클래스를 항상 참조
    inner class ViewHolder(var binding: ItemSettingLanguageRecvBinding) : RecyclerView.ViewHolder(
        binding.root
    )
}