package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf(
            "문자열 1","문자열2","문자열3","문자열4","문자열5",
            "문자열 6","문자열7","문자열8","문자열9","문자열10",
            "문자열 11","문자열12","문자열13","문자열14","문자열15",
            "문자열 16","문자열17","문자열18","문자열19","문자열20",
            "문자열 21","문자열22","문자열23","문자열24","문자열25",
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //첫번째 : Context
        //두번째 : 항목 하나를 구성하기 위해 사용할 Layout 파일
        //세번째 : 적용할 컬렉션
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1,data1)
        List1.adapter = adapter1

        List1.setOnItemClickListener(listener1)

    }

    val listener1 = object : AdapterView.OnItemClickListener{

        //첫 번째 : 이벤트가 발생한 항목을 가지고 있는 AdapterView
        //두 번째 : 이벤트가 발생한 항목 View
        //세 번째 : 이벤트가 발생한 항목의 index
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(parent?.id){
                R.id.List1 -> {
                    textView.text = "${data1[position]} 번째 항목을 클릭했습니다"
                }
            }
        }

    }
}
/*
ListView
가장 대표적이고 가장 많이 사용하는 AdapterView 이다.

지금은 RecyclerView 사용을 추천하고 있지만 AdapterView 개념을 공부하기에 적당하다

RecycleView가 내부적으로 관리의 효율성을 가지고 있지만 지금도 ListView를 많이 사용하고 있다

RecyclerView를 사용할 정도가 아니라면 ListView를 사용해도 된다.


주요 프로퍼티

adapter : AdapterView를 구성하기 위해 사용하는 adapter를 관리

주요 이벤트

ItemClick : 항목을 터치하면 발생

 */