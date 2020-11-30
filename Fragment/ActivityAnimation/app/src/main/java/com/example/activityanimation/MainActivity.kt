package com.example.activityanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
//            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
//            overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_in)
           overridePendingTransition(R.anim.slide_xml1,R.anim.slide_xml2)
        }
    }
}
/*
Activity도 Fragment처럼 애니메이션을 정의할 수 있다
Activity는 Fragment와 달리 기본 애니메이션이 설정되어 있으므로 기본 사용해도됨
주의할 점은 나타나는 Activity, 사라지는 Activity 모두 설정 해야한다
애니메이션 설정은 overridePendingTransition 메서드를 사용한다
 */