package com.example.button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //버튼에 리스너 설정
        button1.setOnClickListener(listener1)
        imageButton1.setOnClickListener(listener2)
        button2.setOnClickListener(listener3)
        button3.setOnClickListener(listener3)

        //코틀린에서 리스너 설정
        button4.setOnClickListener{
            text1.text = "다섯 번째 버튼을 눌렀습니다"
        }


    }
    //버튼을 클릭하면 동작하는 리스너 객체
    val listener1 = object : View.OnClickListener{
        override fun onClick(v: View?) {
            text1.text = "첫 번째 버튼을 눌렀습니다."
        }

    }
    val listener2 = object : View.OnClickListener{
        override fun onClick(v: View?) {
            text1.text = "이미지 버튼을 눌렀습니다."
        }

    }
    //한꺼번에 처리
    val listener3 = object :View.OnClickListener{
        override fun onClick(v: View?) {
            when(v?.id){
                R.id.button2 -> {
                    text1.text = "세번째 버튼을 눌렀습니다"
                }
                R.id.button3 -> {
                    text1.text = "네번째 버튼을 눌렀습니다="
                }
            }
        }

    }

}

/*
Button
사용자가 클릭하면 개발자가 만든 코드를 동작시켜 주는 View
Button은 문자열을 표시하는 Button과 이미지를 표시하는 ImageButton이 있다.

Button의 주요 속성
- text : Button의 문자열을 설정
- srcCompat : ImageButton의 이미지를 설정

Button의 이벤트
- OnClick: 사용자가 Button을 Click하면 발생하는 이벤트

여러 View에 대한 처리를 동시에 할 경우에는 Listener방식 선호.
각각 따로 처리할 때는 고차 함수 방식 추천.
 */