package com.example.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            textView.text = "현재 값 : ${progressBar6.progress}"

        }

        button2.setOnClickListener {
            progressBar6.progress = 140
        }

        button3.setOnClickListener {
            progressBar6.incrementProgressBy(10)
        }
        button4.setOnClickListener {
            progressBar6.incrementProgressBy(-10)
        }

    }
}
/*
style : ProgressBar의 모양을 설정
max : 최대 값
progress : 현재 값

ProgressBar의 주요 메서드
- incrementProgressBy : 지정한 값 만큼 증가 혹은 감소시킨다
 */