package com.example.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/*
ConstraintLayout은 RelativeLayout 처럼 부모와의 관계나 다른 View와의 관계를 설정하게 된다.
제약 조건은 다음과 같이 두 가지를 사용할 수 있다.
1. 실선제약 조건 : 지정된 기준으로부터 얼마큼 떨어진 위치에 있는지 좌표 설정(절대적)
2. 스프링 제약 조건 : 지정된 기준으로부터 얼만큼 떨어진 위치에 있는지 비율을 설정(상대적)
 */