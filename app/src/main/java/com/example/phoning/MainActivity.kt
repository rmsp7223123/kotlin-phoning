package com.example.phoning

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.phoning.Setting.SettingActivity
import com.example.phoning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // var = 불변(값의 읽기만 허용되는 변수)
    // val = 가변(값의 읽기와 쓰기가 모두 허용되는 변수)

    // 전역 변수로 바인딩 객체 선언
    // ?(nullable)  = null 을허용하는
    private var mBinding : ActivityMainBinding? = null
    //           변수이름 :   타입  =
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() =  mBinding!! // !! = 널안전연산자 ( 변수가 절대로 null일 수 없음)

    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val hideActionBar = HideActionBar()
        hideActionBar.hideActionBar(this)

        binding!!.relativeSettings.setOnClickListener(View.OnClickListener {
            // :: 참조
            intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        })

        binding!!.relativeClick.setOnClickListener(View.OnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://newjeans.kr/"))
            startActivity(intent)
        });

    }

    override fun onDestroy() {
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null;
        super.onDestroy()
    }
}