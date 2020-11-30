package com.example.aswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            if (switch2.isChecked) {
                textView.text = "ON"

            } else {
                textView.text = "OFF"
            }
        }
        button2.setOnClickListener {
            switch2.isChecked = true

        }

        button3.setOnClickListener {
            switch2.isChecked = false

        }
        switch2.setOnCheckedChangeListener(listener1)
        switch3.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                textView2.text = "두 번째 스위치 ON"
        }else{
                textView2.text = "두 번째 스위치 OFF"
            }
        }

    }

    val listener1 =object : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            when(buttonView?.id){
                R.id.switch2 -> {
                    if(isChecked){
                        textView.text = "첫 번째 스위치 ON"
                    }else{
                        textView.text = "첫 번째 스위치 OFF"
                    }
                }
            }
        }
    }
}

/*
Switch
ON/OFF 상태를 좌우로 이동하면서 설정할 수 있는 View 이다

속성
thumb : 버튼 부분의 이미지 설정
track : 트랙 부분의 이미지 설정
textOn : On 상태일 때 표시되는 문자열을 설정
textOff: off상태일 때 표시되는 문자열을 설정
showText : textOn, textOff에 설정한 문자열을 보여줄 것인가를 설정
checked : ON/OFF 상태를 설정

주요 프로퍼티
isChecked : Switch의 ON/OFF 상태 값

주요 이벤트
- checkedChange : Switch의 ON/OFF상태가 변경되었을 때


 */