package com.example.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = ""

            if (checkBox.isChecked == true) {
                textView.append("첫 번째 체크박스가 체크되어 있습니다.\n")
            } else {
                textView.append("첫 번째 체크박스가 체크되어있지 않습니다.\n")
            }
            if (checkBox2.isChecked == true) {
                textView.append("두 번째 체크박스가 체크되어 있습니다.\n")
            } else {
                textView.append("두 번째 체크박스가 체크되어있지 않습니다.\n")
            }
            if (checkBox3.isChecked == true) {
                textView.append("세 번째 체크박스가 체크되어 있습니다.\n")
            } else {
                textView.append("세 번째 체크박스가 체크되어있지 않습니다.\n")
            }
        }

        button2.setOnClickListener {
            checkBox.isChecked = true
            checkBox2.isChecked = true
            checkBox3.isChecked = true

        }
        button3.setOnClickListener {
            checkBox.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false

        }
        //체크 상태 반전하기 toggle
        button4.setOnClickListener {
            checkBox.toggle()
            checkBox2.toggle()
            checkBox3.toggle()
        }

        checkBox.setOnCheckedChangeListener(listener)
        checkBox2.setOnCheckedChangeListener(listener)
        checkBox3.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                textView.text = "세 번째 체크박스가 체크되었습니다"
            }
            else{
                textView.text = "세 번째 체크박스가 해제되었습니다"
            }
        }



    }
        val listener = object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                when(buttonView?.id){
                    R.id.checkBox -> {
                        if(isChecked == true){
                            textView.text = "첫 번째 체크박스가 체크되었습니다."
                        }else{
                            textView.text = "첫 번째 체크박스가 해제되었습니다"
                        }

                    }
                    R.id.checkBox2 -> {
                        if(isChecked == true){
                            textView.text = "두 번째 체크박스가 체크되었습니다."
                        }else{
                            textView.text = "두 번째 체크박스가 해제되었습니다"
                        }

                    }
                }

            }

        }
    }

/*
CheckBox
- 선택할 수 있는 항목 들을 제공하고 체크를 통해 선택할 수 있도록 하는 View
- 다수의 CheckBox를 동시에 선택할 수 있다.

주요 속성
- text : CheckBox에 표시되는 문자열을 설정
- checked : 체크 상태를 설정 true는 체크 상태로 시작

주요 프로퍼티
isChecked : 체크 박스의 현재 체크 값

주요 이벤트
checkedChange : 체크 상태가 변경되는 사건
 */