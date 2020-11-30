package com.example.a9patchimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/*
9patch이미지

9patch이미지는 이미지의 늘어날 부분을 설정한 이미지이다
늘어나는 영역으로 설정된 부분만 늘어나고 그렇지 않는 부분은 늘어나지 않기
때문에 이미지가 늘어나더라도 이상하게 나타나지 않게 할 수 있다.
 */