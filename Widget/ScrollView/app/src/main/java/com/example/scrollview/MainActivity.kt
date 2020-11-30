package com.example.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "Y : ${scroll1.scrollY}"
            textView2.text = "X : ${scroll1.scrollX}"
        }

        button2.setOnClickListener {
//            scroll1.scrollTo(0,1000)
//            scroll2.scrollTo(1000,0)
//            scroll1.smoothScrollTo(0,1000) //애니메이션 효과 적용되며 이동
//            scroll1.smoothScrollTo(1000,0)
            scroll1.smoothScrollBy(0,1000)  //현재 위치에서 지정된 값만큼 이동 - 계속 가능
            scroll2.smoothScrollBy(1000,0)
        }

        scroll1.setOnScrollChangeListener(listener1)

        scroll2.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            textView2.text = "X : ${oldScrollX} -> ${scrollX} "
        }
    }

    val listener1 = object : View.OnScrollChangeListener{
        override fun onScrollChange(v: View?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int
        ){
            when(v?.id){
                R.id.scroll1 -> {
                    textView.text= "Y : ${oldScrollY} -> ${scrollY}"
                }


            }
        }



    }


}

/*
ScrollView
ScrollView는 배치되어 있는 View가 화면을 벗어 날 경우 스크롤을 할 수 있도록 제공되는 View
기본은 위아래, HorizontalScrollView는 좌우로 스크롤 가능
ScrollView와 HorizontalScrollView를 조합하면 상하 좌우 스크롤 가능
 */