package com.example.phoning

import android.graphics.Color
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class HideActionBar {
    // 액션바 숨기기
    fun hideActionBar(activity: AppCompatActivity) {
        activity.supportActionBar?.hide()
        val window: Window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        window.statusBarColor = Color.TRANSPARENT
        val view: View = activity.window.decorView
        view.systemUiVisibility = view.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
    }
}