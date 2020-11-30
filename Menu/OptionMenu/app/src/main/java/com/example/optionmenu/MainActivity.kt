package com.example.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //XML로 메뉴를 구성
//        menuInflater.inflate(R.menu.main_menu,menu)

        //코드로 메뉴 구성
        menu?.add(Menu.NONE,Menu.FIRST,Menu.NONE, "코드 메뉴 1")
//        menu?.add(Menu.NONE,Menu.FIRST +1 ,Menu.NONE, "코드 메뉴 2")
        val sub = menu?.addSubMenu("코드 메뉴 1")
        sub?.add(Menu.NONE, Menu.FIRST + 10,Menu.NONE,"코드 메뉴 2-1")
        sub?.add(Menu.NONE, Menu.FIRST + 20,Menu.NONE,"코드 메뉴 2-2")


        menu?.add(Menu.NONE,Menu.FIRST +2 ,Menu.NONE, "코드 메뉴 3")


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        //메뉴의 id별로 분개
        when(item.itemId){
            R.id.item1 -> {
                textView.text = "메뉴 1을 눌렀습니다"
            }
//            R.id.item2 -> {
//                textView.text = "메뉴 2을 눌렀습니다"
//            }

            R.id.item2_1 -> {
                textView.text = "메뉴 2-1을 눌렀습니다"
            }
            R.id.item2_2 -> {
                textView.text = "메뉴 2-2을 눌렀습니다"
            }
            R.id.item3 -> {
                textView.text = "메뉴 3을 눌렀습니다"
        }
        }

        return super.onOptionsItemSelected(item)
    }
}
/*
onCreateOptionsMenu
화면을 관리하는 객체인 Activity 객체가 만들어 질 때 자동으로 호출되는 메서드이며 여기서 메뉴 생성
true반환하면 메뉴가 나타남

onOptionsItemSelected
사용자가 메뉴를 선택했을 때 자동으로 호출되는 메서드
 */