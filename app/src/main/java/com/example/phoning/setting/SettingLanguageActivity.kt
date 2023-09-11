package com.example.phoning.setting

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.common.SettingCommon
import com.example.phoning.databinding.ActivitySettingLanguageBinding
import com.example.phoning.dto.LanguageDTO

class SettingLanguageActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingLanguageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        val adapter = SettingLanguageAdapter(getLanguageList())
//        binding.recvLanguage.adapter = adapter
//        binding.recvLanguage.layoutManager = LinearLayoutManager(this)
        binding.recvLanguage.apply {
            layoutManager = LinearLayoutManager(this@SettingLanguageActivity)
            // @ 현재 코드가 작성된 클래스
            this.adapter = adapter
        }
        binding.tvDone.setOnClickListener { _ : View? ->
//            var j: String? = null
//            for (i in adapter.list.indices) {
//                if (adapter.list[i].isChecked) {
//                    j = adapter.list[i].tv_lg
//                }
//            }
//            val intent = Intent()
//            intent.putExtra("language", j)
//            setResult(RESULT_OK, intent)
//            finish()

            val selectedLanguage = adapter.getSelectedLanguage() ?: ""
            setResultAndFinish(selectedLanguage)
        }


        binding.tvBack.setOnClickListener {
//            val resultIntent = Intent()
//            resultIntent.putExtra("language", SettingCommon.setting_language)
//            setResult(RESULT_OK, resultIntent)
//            finish()
            setResultAndFinish(SettingCommon.setting_language)
        }
    }

//    val list: ArrayList<LanguageDTO>
//        get() {
//            val list = ArrayList<LanguageDTO>()
//            list.add(LanguageDTO(false, "English"))
//            list.add(LanguageDTO(false, "한국어"))
//            list.add(LanguageDTO(false, "日本語"))
//            list.add(LanguageDTO(false, "中國語"))
//            list.add(LanguageDTO(false, "Español"))
//            list.add(LanguageDTO(false, "français"))
//            list.add(LanguageDTO(false, "Deutsch"))
//            list.add(LanguageDTO(false, "Русский"))
//            list.add(LanguageDTO(false, "português "))
//            list.add(LanguageDTO(false, "tiếng Việt"))
//            list.add(LanguageDTO(false, "Bahasa Indonesia"))
//            list.add(LanguageDTO(false, "Italiano"))
//            list.add(LanguageDTO(false, "الْعَرَبِيَّة"))
//            list.add(LanguageDTO(false, "Türkçe "))
//            list.find { it.tv_lg == SettingCommon.setting_language }?.isChecked = true
            // find : 탐색을 앞에서 부터 시작 하여 만족 하는 원소가 있다면 반환, 없다면 null
            // findLast : 탐색을 뒤에 서부터 시작 하여 만족 하는 원소가 있다면 반환, 없다면 null
            // it는 람다식 에서 현재 반복 되는 리스트 요소를 나타 내는 변수 즉, list의 각 요소를 it로 차례로 대응 시키며 조건을 비교
            // null이 아닐 때만 isChecked = true

//            for (i in list.indices) {
//                // indices -> Collection, Array 클래스에 선언 되어 있는 프로퍼티로 컬렉션 타입의 인덱스 범위를 반환
//                // indices 함수를 사용해 배열 데이터 해당 인덱스 번지를 지정해 출력
//                if (list[i].tv_lg.toString() == SettingCommon.setting_language) {
//                    list[i] = LanguageDTO(true, list[i].tv_lg)
//                }
//            }
//            return list
//        }

    private fun getLanguageList(): ArrayList<LanguageDTO> {
        val languageArray = resources.getStringArray(R.array.language_array)
        val selectedLanguage = SettingCommon.setting_language
        val list = ArrayList<LanguageDTO>()

        for (language in languageArray) {
            // languageArray를 순회하는 반복문
            val isChecked = (language == selectedLanguage)
            // 현재 언어항목과 같으면 true
            val languageDTO = LanguageDTO(isChecked, language)
            list.add(languageDTO)
        }

        return list
    }

    private fun setResultAndFinish(language: String) {
        val intent = Intent()
        intent.putExtra("language", language)
        setResult(RESULT_OK, intent)
        finish()
    }
}