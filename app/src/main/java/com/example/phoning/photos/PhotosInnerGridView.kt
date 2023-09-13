package com.example.phoning.photos

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.GridView

class PhotosInnerGridView : GridView {

    // 그리드뷰를 상속하여 만들어진 커스텀 뷰
    // 그리드 뷰의 높이를 그리드의 내용물에 따라 동적으로 조정하여 화면에 더 많은 항목을 표시

    constructor(context: Context) : super(context)
    // Context를 매개변수로 받아서 super(context)를 호출하며, GridView의 첫 번째 생성자를 호출 즉, 컨텍스트를 받아 그리드 뷰를 초기화하는 생성자

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    // Context와 AttributeSet을 매개변수로 받아서 super(context, attrs)를 호출하며, GridView의 두 번째 생성자를 호출
    // AttributeSet은 XML에서 뷰의 속성을 정의하기 위해 사용

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)
    // Context, AttributeSet, 그리고 defStyle을 매개변수로 받아서 super(context, attrs, defStyle)를 호출하며, GridView의 세 번째 생성자를 호출
    // defStyle은 뷰의 스타일을 지정하는 데 사용

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // 그리드뷰의 높이를 설정
        // MeasureSpec.makeMeasureSpec를 사용하여 측정 사양(MeasureSpec)을 만들고, 그 높이를 현재 뷰의 높이의 1/4로 설정
        val expandSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec) shr 2,
            MeasureSpec.AT_MOST)

        super.onMeasure(widthMeasureSpec, expandSpec)
        // super.onMeasure를 호출하여 실제로 뷰의 크기를 설정 이 때, widthMeasureSpec는 너비 측정 사양을, expandSpec는 높이 측정 사양을 사용
    }
}