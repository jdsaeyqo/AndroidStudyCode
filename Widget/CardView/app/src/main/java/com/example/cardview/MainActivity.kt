package com.example.cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
/*
화면에 배치되는 View들을 그룹으로 묶어 관리할 수 있는 View이다

CardView 자체에 그림자를 두어 약간 공중에 떠 있는 듯한 모습을 줄 수 있음

주요 속성
- contentPadding : CardView 내부의 여백을 설정
- cardCornerRadius : CardView 모서리 부분의 둥근 정도를 설정
- cardElevation : CardView가 공중에 떠있는 정도를 설정
 */