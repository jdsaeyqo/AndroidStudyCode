package com.example.includeotherlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
/*
Layout에서 다른 Layout을 포함시킬 수 있는 개념
다수의 화면을 구성할 때 중복되는 부분이 있을 경우 사용


주요 속성
layout : 삽일할 화면의 데이터를 정의한 layout파일


 */