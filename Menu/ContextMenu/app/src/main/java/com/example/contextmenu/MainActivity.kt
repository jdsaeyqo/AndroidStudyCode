package com.example.contextmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf(
            "항목1","항목2","항목3","항목4","항목5"
    )





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,data1)
            list1.adapter = adapter1

        list1.setOnItemClickListener { adapterView, view, i, l ->
            textView.text = "리스트 뷰의 항목 클릭 : ${data1[i]}"
        }


        // ContextMenu를 View에 등록한다.
        registerForContextMenu(textView)
        registerForContextMenu(list1)
    }






    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        //길게 누른 View의 id로 분기
        when(v?.id){
            R.id.textView -> {
                menu?.setHeaderTitle("텍스트 뷰의 메뉴")
                menuInflater.inflate(R.menu.menu1,menu)
            }
            R.id.list1 -> {
                //사용자가 길게 누른 항목 인덱스 번호를 파악하기 위해
                val info = menuInfo as AdapterView.AdapterContextMenuInfo


                menu?.setHeaderTitle("리스트 뷰의 메뉴 : ${info.position}")
                menuInflater.inflate(R.menu.menu2,menu)

            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        //리스트 항목의 인덱스 번호를 받을 변수
        var position = 0
        when(item.itemId){
            R.id.list_item1,R.id.list_item2 -> {
                //MenuInfo 객체를 추출
                val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                position = info.position
            }
        }


        //메뉴의 id값으로 분기
        when(item.itemId){
            R.id.text_item1 -> {
                textView.text = "텍스트 뷰의 메뉴1을 눌렀습니다"
            }
            R.id.text_item2 -> {
                textView.text = "텍스트 뷰의 메뉴2를 눌렀습니다"
            }
            R.id.list_item1 -> {
                textView.text = "리스트 뷰의 메뉴1을 눌렀습니다 : $position"
            }
            R.id.list_item2 -> {
                textView.text = "리스트 뷰의 메뉴2을 눌렀습니다 : $position"
            }

        }

        return super.onContextItemSelected(item)
    }




}
/*
화면에 배치된 View에 설정할 수 있는 메뉴
메뉴가 설정된 View를 길게 누르면 메뉴가 나타난다

메서드

registerForContext
- Context Menu를 등록하는 메서ㅔ드
- 메서드의 매개 변수로 넣어준 View 객체에 메뉴가 설정

onCreateContextMenu

 */