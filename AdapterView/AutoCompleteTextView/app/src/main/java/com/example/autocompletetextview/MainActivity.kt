package com.example.autocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf(
            "abcd","abca","abcb","abcc","bbaa","bbab","bcab","bdab"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,data1)

        autoCompleteTextView.setAdapter(adapter1)

        button.setOnClickListener {
            textView.text = autoCompleteTextView.text
        }
//        autoCompleteTextView.setOnItemClickListener(listener1)

        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            textView2.text = "${data1[position]}항목을 클릭했습니다"
        }


    }

//    val listener1 = object :AdapterView.OnItemClickListener{
//        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//
//                    textView2.text = "${data1[position]}항목을 클릭하였습니다"
//
//            }
//        }

    }


/*
AutoCompleteTextView의 주요 메서드
- setAdapter : AutoCompleteTextView는 Adapter를 메서드를 통해 설정

주요 속성

-completionThreshold : 몇 글자 입력했을 때 자동완성 나타내 주는 지 설정
-text : 사용자가 입력한 문자열 값

주요 이벤트
ItemClick
 */