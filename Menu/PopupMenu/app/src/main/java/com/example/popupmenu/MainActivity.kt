package com.example.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            //팝업 메뉴 객체 생성
            val pop = PopupMenu(this,textView)

            //메뉴 구성
            menuInflater.inflate(R.menu.menu1,pop.menu)

            pop.setOnMenuItemClickListener {

              when(it.itemId){
                  R.id.item1 -> {
                      textView.text = "메뉴 1을 눌렀습니다"
                  }
                  R.id.item2 -> {
                      textView.text = "메뉴 2를 눌렀습니다"
                  }
                  R.id.item3 -> {
                      textView.text = "메뉴 3을 눌렀습니다"
                  }
              }

                true
            }

            pop.show()
        }
    }
}
/*
 PopupMenu는 개발가자 원할 때 원하는 곳에 띄울 수 있는 메뉴

 주요 프로퍼티
 menu

 리스
 onMenuItemClickListener : 메뉴 항목 눌렀을 때 반응하는 리스너
 */