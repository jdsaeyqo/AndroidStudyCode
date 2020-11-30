package com.example.textview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //뷰의 주소값을 얻어온다 - 자바는 필수
        val text1 = findViewById<TextView>(R.id.text1)

        text1.text ="안녕하세요"
        
        text2.text = "반갑습니다" //코틀린은 바로 부를 수 있음.

       text2.setBackgroundColor(Color.GREEN) //글자 배경색
//        text2.setBackgroundColor(Color.rgb( , , )) 디자이너가 rgb값 알려주면 작성하면 됨
        //text2.setBackgroundColor(Color.argb( , , )) 투명도

        text2.setTextColor(Color.BLUE)      //글자 텍스트 색

        text2.append("\n감사합니다")

    }
}

/*
View 객체의 주소 값 가져오기
- 코드에서 View를 제어하기 위해서는 View 객체의 주소 값을 얻어와야 한다.
 val text1 = findViewById<TextView>(R.id.textView)

- 자바로 개발할 때는 개발자가 View 객체의 주소 값을 직접 얻어와야 하지만 Kotlin의 경우
id와 같은 이름의 변수가 자동으로 선언되고 View의 주소값도 담겨있게 된다.


TextView의 주요 속성

- text : TextView를 통해 보여줄 문자열
- lines : 표시하고자 하는 문자열의 라인 수
- textColor : 표시되는 문자열의 생성
- textSize : 표시되는 문자열의 크기
- textAppearance : 표시되는 문자열의 형식

TextView의 주요 프로퍼티
text : TextView를 통해 보여주는 문자열을 관리

TextView의 주요 메서드
-setBackgroundColor : 배경 색상을 지정
-setTextColor : 글자 색상을 지정
-append : 문자열을 추가.
 */