package com.example.framelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/*
FrameLayout에 배치되는 View는 모두 좌측 상단에 배치
margin 속성이나 layout_gravity 속성을 이용해 배치되는 위치를 결정하여 사용
중첩해서 View를 배치할 수 있는 Layout - 크게 많이 사용되지는 않음.
 */