package com.example.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            radioButton3.isChecked = true
            radioButton6.isChecked = true
        }

        button2.setOnClickListener {
            when (radiogroup1.checkedRadioButtonId) {
                R.id.radioButton -> {
                    textView.text = "라디오 1-1이 체크되어 있습니다."
                }
                R.id.radioButton2 -> {
                    textView.text = "라디오 1-2이 체크되어 있습니다."
                }
                R.id.radioButton3 -> {
                    textView.text = "라디오 1-3이 체크되어 있습니다."
                }
            }
            when (radiogroup2.checkedRadioButtonId) {
                R.id.radioButton4 -> {
                    textView2.text = "라디오 2-1이 체크되어 있습니다"
                }
                R.id.radioButton5 -> {
                    textView2.text = "라디오 2-2이 체크되어 있습니다"
                }
                R.id.radioButton6 -> {
                    textView2.text = "라디오 2-3이 체크되어 있습니다"
                }
            }

        }
        radiogroup1.setOnCheckedChangeListener(listener)
        radiogroup2.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.radioButton4 -> {
                    textView2.text = "라디오 2-1이 체크되었습니다"
                }
                R.id.radioButton5 -> {
                    textView2.text = "라디오 2-2이 체크되었습니다"
                }
                R.id.radioButton6 -> {
                    textView2.text = "라디오 2-3이 체크되었습니다"
                }
            }
        }
    }


    val listener= object : RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
            when(group?.id){
                R.id.radiogroup1 -> {
                    when(checkedId){
                        R.id.radioButton -> {
                            textView.text = "라디오 1-1이 체크되었습니다"
                        }
                        R.id.radioButton2 -> {
                            textView.text = "라디오 1-2이 체크되었습니다"
                        }
                        R.id.radioButton3 -> {
                            textView.text = "라디오 1-3이 체크되었습니다"
                        }
                    }
                }

            }
        }

    }
}
/*
RadioButton
하나의 그룹 안에서 하나만 선택할 수 있도록 하는 View

주요 속성
-text : RadioButton에 표시되는 문자열을 설정
-checked : 체크상태를 설정. RadioButton은 그룹 내에서 반드시 하나는 선택되어
           있는 상태로 제공되는 목적으로 사용하는 View이므로 반드시 하나는
           체크해야함.

 주요 프로퍼티
 - isCheked : RadioButton 체크 상태 값. 체크 상태 설정 시 같은 그룹 내의
             RadioButton은 모두 체크가 해제된 상태가 된다

 - checkedRadioButtonld : 그룹 내에서 선택되어 있는 RadioButton의 id

주요 이벤트
- checkedChange : 그룹 내의 RadioButton의 체크 상태가 변경되었을 때

*/