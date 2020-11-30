package com.example.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("그리드1","그리드2","그리드3","그리드4","그리드5,",
                        "그리드6","그리드7","그리드8","그리드9","그리드10")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,data1)

        Grid1.adapter = adapter1

        //Grid1.setOnItemClickListener(listener1)
        // 항목이 하나밖에 없으므로 람다식 제공
       Grid1.setOnItemClickListener { parent, view, position, id ->
            textView.text = "${data1[position]}항목을 클릭하였습니다"
        }

    }

    val listener1 = object :AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(parent?.id){
                R.id.Grid1 -> {
                    textView.text = "${data1[position]}항목을 클릭하였습니다"
                }
            }
        }

    }

}

/*
nuncolumns : 그리드 구성할 칸의 개수. auto_fit으로 설정하면 디바이스에 맞게 자동으로 구성

ItemClick   : 사용자가
 */