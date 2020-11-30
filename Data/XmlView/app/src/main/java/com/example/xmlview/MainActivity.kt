package com.example.xmlview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_sub1.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //View 객체를 생성
        val sub1 = layoutInflater.inflate(R.layout.layout_sub1,null)
        val sub2 = layoutInflater.inflate(R.layout.layout_sub2,null)
        // null 대신 container 넣으면 시작부터 들어가있고 지울수 없음
        val sub3 = layoutInflater.inflate(R.layout.layout_sub3,container)

        sub1.run {
            sub1_btn.setOnClickListener {
                sub1_text.text = "sub1의 버튼을 눌렀습니다"
                textView.text = "sub1의 버튼을 눌렀습니다"
            }
        }


        button.setOnClickListener {
            container.addView(sub1)
            container.addView(sub2)
        }

        button2.setOnClickListener {
            container.removeView(sub1)
            container.removeView(sub2)
        }
    }
}