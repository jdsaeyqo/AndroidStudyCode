package com.example.togglebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            if(toggleButton.isChecked == true){
                textView.text = "ON 상태입니다"
            }else{
                textView.text = "OFF상태 입니다"
            }
        }

        button2.setOnClickListener{
            toggleButton.isChecked = true
        }
        button3.setOnClickListener{
            toggleButton.isChecked = false

        }
        toggleButton.setOnClickListener(listener)

        toggleButton2.setOnClickListener{
            if(toggleButton.isChecked == true){
                textView2.text = "ON 상태로 설정"
            }else{
                textView2.text = "OFF 상태로 설정"
            }
        }


    }

    val listener = object : View.OnClickListener{
        override fun onClick(v: View?) {
            if(toggleButton.isChecked==true){
                textView.text = "ON상태로 설정"
            }else{
                textView.text = "OFF상태로 설정"
            }
        }

    }
}
/*
ToggleButton
환경설정 같은 화면에서 애플리케이션의 기능을 ON/OFF 하는 기능을 제공하고자 할 때 사용
지금은 더 보기 좋은 View들이 생겨 많이 사용하지는 않음.

주요 속성
- textOn : ON상태일 때 표시할 문자열
- textOff: OFF상태일 때 표시할 문자열
- checked : true이면 ON상태에서 시작하고 false이면 OFF상태에서 시작.

프로퍼티

ischecked : ON/OFF 상태 여부값을 나타냄

메서드
-toggle : 현재 상태를 변경시킴

이벤트
-click : Toggle 버튼을 클릭하면 발생하는 이벤트
 */