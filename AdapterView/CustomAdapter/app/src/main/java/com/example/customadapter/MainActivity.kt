package com.example.customadapter

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*


class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("데이터1","데이터2","데이터3","데이터4","데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list1.adapter = adapter1
    }

    val adapter1  = object :BaseAdapter(){

        //항목의 개수 반환
        override fun getCount(): Int {
            return data1.size

        }

        override fun getItem(position: Int): Any?   {   //크게 관여 안하므로 설정 X
            return null
        }

        override fun getItemId(position: Int): Long {    //크게 관여 안하므로 설정 X
            return 0
        }



        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            // 넘어가는 View를 버리지않고 저장했다가 새로 만들때 재활용하여 메모리 절약
            // 재사용 가능한 View를 변수에 담는다
            var rowView = convertView

            if(rowView == null){
                rowView = layoutInflater.inflate(R.layout.row,null)
            }


            //항목 View 내부에 배치되어 있는 뷰들의 주소값을 가져온다.
//            val text1 = rowView?.findViewById<TextView>(R.id.rowTextView)
//            val btn1 = rowView?.findViewById<Button>(R.id.rowButton1)
//            val btn2 = rowView?.findViewById<Button>(R.id.rowButton2)
//
//            text1?.text = data1[position]
//
//            btn1?.tag = position
//            btn2?.tag = position
//
//            btn1?.setOnClickListener {
//                textView.text = "첫 번째 버튼을 눌렀습니다 : ${it.tag}"
//            }
//
//            btn2?.setOnClickListener {
//                textView.text = "두 번째 버튼을 눌렀습니다 : ${it.tag}"
//            }

            rowView?.run {
                rowTextView.text = data1[position]

                rowButton1.tag = position
                rowButton2.tag = position

                rowButton1.setOnClickListener {
                    textView.text = "첫 번째 버튼을 눌렀습니다 : ${it.tag}"
                }
                rowButton2.setOnClickListener {
                    textView.text = "두 번째 버튼을 눌렀습니다 : ${it.tag}"
                }
            }

            return rowView!!

        }

    }
}
/*
이번에는 Adapter 클래스를 직접 만들어 본다
AdapterView의 항목을 자유롭게 디자인해서 사용할 때는 SimpleAdapter만으로도 충분하다
하지만 AdapterView 자체를 커스터마이징하여 특별한 기능을 부여하고 싶을 때는 Adapter 클래스를
구현하면 된다.

BaseAdapter
- BaseAdapter를 상속받아 다음 메서드를 구현하면 된다.
- getCount : AdapterView를 통해 보여줄 항목의 개수를 반환
- getView : AdapterView를 통해 보여줄 항목의 View를 반환
 */