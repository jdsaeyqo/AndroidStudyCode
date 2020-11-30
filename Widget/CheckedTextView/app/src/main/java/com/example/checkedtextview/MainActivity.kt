package com.example.checkedtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckedTextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            //체크박스
            if(checkedTextView.isChecked == true){
                textView.append("첫 번째 체크박스가 체크되어 있습니다\n")
            }else{
                textView.append("첫 번째 체크박스가 해제되어 있습니다\n")
            }

            if(checkedTextView2.isChecked == true){
                textView.append("두 번째 체크박스가 체크되어 있습니다\n")
            }else{
                textView.append("두 번째 체크박스가 해제되어 있습니다\n")
            }
            if(checkedTextView3.isChecked == true){
                textView.append("세 번째 체크박스가 체크되어 있습니다\n")
            }else{
                textView.append("세 번째 체크박스가 해제되어 있습니다\n")
            }


        }

        if(checkedTextView4.isChecked == true){
            textView.append("첫 번째 라디오 버튼이 선택되어 있습니다\n")

        }
        if(checkedTextView5.isChecked == true){
            textView.append("두 번째 라디오 버튼이 선택되어 있습니다\n")

        }
        if(checkedTextView6.isChecked == true){
            textView.append("세 번째 라디오 버튼이 선택되어 있습니다\n")

        }

        button2.setOnClickListener{
            checkedTextView.isChecked = false
            checkedTextView2.isChecked = true
            checkedTextView3.isChecked = false

            checkedTextView4.isChecked = false
            checkedTextView5.isChecked = false
            checkedTextView6.isChecked = true
        }

        checkedTextView.setOnClickListener(listener1)
        checkedTextView2.setOnClickListener(listener1)
        checkedTextView3.setOnClickListener(listener1)

        checkedTextView4.setOnClickListener(listener2)
        checkedTextView5.setOnClickListener(listener2)
        checkedTextView6.setOnClickListener(listener2)


    }//체크 기능
    val listener1  = object : View.OnClickListener{
        override fun onClick(v: View?) {

            //형변환
            val obj = v as CheckedTextView

            if(obj.isChecked == true){
                obj.isChecked = false
            }else{
                obj.isChecked = true
            }
        }

    }

    val listener2 = object:View.OnClickListener{
        override fun onClick(v: View?) {
            checkedTextView4.isChecked = false
            checkedTextView5.isChecked = false
            checkedTextView6.isChecked = false

            val obj = v as CheckedTextView
            obj.isChecked = true
        }

    }
        

}

/*
CheckedTextView
- CheckBox, RadioButton 을 커스터마이징 할 수 있도록 제공되는 View

CheckedTextView의 주요 속성
-CheckMark : 체크 상태를 표시하는 아이콘을 설정
-checked : 체크 상태를 설정
-clickable : 클릭이 가능한지 설정
CheckedTextView는 CheckBos나 RadioButton이 가지고 있는 기능이 구현되어 있지 않다.
이 때문에 개발자가 기능을 모두 구현해줘야 하는데 clickable에 true를 설정해야 이벤트에 반응할
수 있고 이를 통해 리스너를 구현하여 기능을 구현해줘야 한다.

주요 이벤트
click : 클릭했을 때 발생한다. checkedTextView는 이 이벤트를 반드시 설정
        checkedTextView는 checkbox나 radiobutton이 가지고 있는 기능을 click 이벤트 발생 시
        개발자가 모두 처리해 줘야 함.
 */