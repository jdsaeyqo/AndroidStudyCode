package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("문자열 1","문자열 2","문자열 3 ","문자열 4 ","문자열 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this,R.layout.row,R.id.rowTextView,data1)
        list1.adapter = adapter1
        
        list1.setOnItemClickListener { parent, view, position, id ->
            textView.text = "${data1[position]}를 터치하였습니다"

        }

    }
}



/*
기본으로 제공되는 layout파일 대신해 개발자가 직접 작성한 layout을 이용해 ListView를 구성

ListView뿐만 아니라 모든 AdapterView는 동일한 방법으로 설정 가능

여기서는 문자열 하나를 설정하는 방법을 살펴본다
 */