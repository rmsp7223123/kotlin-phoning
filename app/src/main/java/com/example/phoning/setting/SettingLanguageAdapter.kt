package com.example.phoning.setting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phoning.databinding.ItemRecvSettingLanguageBinding
import com.example.phoning.dto.LanguageDTO

class SettingLanguageAdapter(private var list: ArrayList<LanguageDTO>) :
    RecyclerView.Adapter<SettingLanguageAdapter.ViewHolder>(){

    private var selectedLanguageIndex: Int = -1 // 선택된 언어의 인덱스

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRecvSettingLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val idx : Int = position

        val languageItem = list[position]
        holder.binding.radio.text = languageItem.tv_lg

        // 현재 항목이 선택된 언어 항목이면 체크
        holder.binding.radio.isChecked = (position == selectedLanguageIndex)

        holder.binding.radio.setOnClickListener {
            // 이전에 선택된 언어 항목의 체크를 해제
            val previousSelectedIndex = selectedLanguageIndex
            if (previousSelectedIndex != -1) {
                list[previousSelectedIndex].isChecked = false
            }

            // 현재 항목을 선택된 언어로 설정하고 체크
            selectedLanguageIndex = idx
            list[selectedLanguageIndex].isChecked = true

            // 어댑터 갱신
            notifyDataSetChanged()
        }
    }

    fun getSelectedLanguage(): String? {
        return if (selectedLanguageIndex != -1) {
            list[selectedLanguageIndex].tv_lg
        } else {
            null
        }
    }

    // 내부 클래스에서는 외부 클래스를 항상 참조
    inner class ViewHolder(var binding: ItemRecvSettingLanguageBinding) : RecyclerView.ViewHolder(
        binding.root
    )
}