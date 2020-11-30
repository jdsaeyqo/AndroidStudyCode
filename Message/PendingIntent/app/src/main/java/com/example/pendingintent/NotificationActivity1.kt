package com.example.pendingintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notification1.*

class NotificationActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification1)

        //Activity를 실행했을 때 사용한 Intent를 통해 데이터를 추출
        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getIntExtra("data2", 0)

        textView.text = "data1 : ${data1}\n"
        textView.append("data2 : ${data2}")
    }
}