package com.example.singlechoicelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data1 = arrayOf("항목1","항목2","항목3","항목4","항목5","항목6","항목7","항목8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,data1)

        list1.adapter = adapter1
        list1.choiceMode = ListView.CHOICE_MODE_SINGLE      //mode설정
        list1.setItemChecked(2,true) // 3번쨰 위치 체크된 채로 실행됨

        button.setOnClickListener {
            textView.text = "${data1[list1.checkedItemPosition]} 항목이 선택되어 있습니다"
        }
    }
}

/*
다수의 항목을 제공하고 항목 중 하나를 선택할 수 있는 ListView이다
ListView의 Mode를 변경하여 설정

코드 처리
사용자가 선택한 아목이 무엇인지 파악해야 할 떄 ListView의 checkedItemPosition프로퍼티를
이용해 현재 선택된 항목이 무엇인지 파악한다


 */