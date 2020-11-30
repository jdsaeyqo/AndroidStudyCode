package com.example.multichoicelistview

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

        val adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,data1)

        list1.adapter = adapter1
        list1.choiceMode = ListView.CHOICE_MODE_MULTIPLE     //mode설정

        button.setOnClickListener {
            textView2.text = ""

            //현재 체크상태에 관련된 객체를 가져옴

            val boolArray = list1.checkedItemPositions

//            textView2.text = "개수 : ${boolArray.size()}"

            for(idx in 0 until boolArray.size()){
                //textView2.append("${boolArray.keyAt(idx)} ")
                //항목 인덱스 번호
                val key = boolArray.keyAt(idx)

                //해당 항목이 체크되어 있는지 확인
                if(boolArray[key] == true){
                    textView2.append("${data1[key]}")
                }
            }
        }
    }
}