package com.example.viewbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/*
안드로이드에서 눈에 보이는 모든 요소를 View라고 부름.
Widget 과 Layout으로 나뉨.

-Layout : 다른 뷰들을 포함하고 내부의 뷰를 통합 관리하고 내부 View들이 배치되는 모양
-Widget : 문자열 입력, 출력 등 어떤 기능을 가지고 있고 사용자와 상호작용을 하는 View

View의 주요 속성
- id : 지칭하기 위한 속성
- layout_width : View의 가로 길이
- layout_height : View의 세로 길이
- layout_margin : View의 외부 여백
- padding : View의 내부 여백
- background : View의 배경 지정

 */