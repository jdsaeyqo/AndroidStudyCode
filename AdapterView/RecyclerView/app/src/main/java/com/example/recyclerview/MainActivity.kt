package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*

class MainActivity : AppCompatActivity() {

    var imgRes = intArrayOf(
        R.drawable.imgflag1,
        R.drawable.imgflag2,
        R.drawable.imgflag3,
        R.drawable.imgflag4,
        R.drawable.imgflag5,
        R.drawable.imgflag6,
        R.drawable.imgflag7,
        R.drawable.imgflag8
    )

    var data1 = arrayOf(
        "토고", "프랑스문자열을 길게 작성해 주세요", "스위스", "스페인", "일본 문자열을 길게 작성해 주세요", "독일", "브라질", "대한민국"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = RecyclerAdapter()
        recycle1.adapter = adapter1

//        recycle1.layoutManager = LinearLayoutManager(this)
//        recycle1.layoutManager = GridLayoutManager(this,2)
//        recycle1.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        recycle1.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)

    }
    //RecyclerView의 Adapter크래스

    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>(){

        //항목 구성을 위해 사용할 ViewHolder 객체가 필요할 때 호출되는 메서드
       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            //항목으로 사용할 View객체를 생성
            val itemView = layoutInflater.inflate(R.layout.row,null)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)

            return holder
        }

        //ViewHolder 클래스
        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {



                //항목 View 내부의 View객체의 주소값을 담는다.
                val rowImageView = itemView.rowimageView
                val rowTextView = itemView.rowTextView

            override fun onClick(v: View?) {
                textView.text = data1[adapterPosition]
            }


        }



        //ViewHolder를 통해 항목을 구성할 때 항목 내의 View 객체에 데이터를 세팅
        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

            holder.rowImageView.setImageResource(imgRes[position])
            holder.rowTextView.text = data1[position]


            }
        //개수 반환
        override fun getItemCount(): Int {
            return imgRes.size
        }
    }
}


/*
RecyclerView 는 Adapter를 직접 구현해줘야 하며 이를 통해 항목을 자유롭게 구성

RecyclerView는 반드시 항목들을 어떠한 보여줄 것인가를 설정

1. ViewHolder 만들기
  - ViewHolder 클래스는 항목 하나를 구성하는 View들의 주소값을 가지고 있는 클래스
  - 이 클래스는 RecyclerView의 Adapter 클래스 내부에 구현하여 준다.

  //inner class ViewHolderClass(itemView : View) : RecyclerView.ViewHolder(itemView){
        val rowImageView = itemView.rowImageView
        val rowTextView = itemView.rowTextView

2. Adapter클래스
 - RecyclerView는 RecyclerView.Adapter 클래스를 상속받은 클래스를 작성하여 Adapter를 구성해야 한다

 - OnCreateViewHolder : RecyclerView는 항목 하나를 구성하기 위해 ViewHolder를 사용한다.
                        ViewHolder는 항목 내부를 구성하는 View 객체들을 관리하는 객체로
                        ViewHolder를 생성하고자 할 때 이 메서드를 호출

 - onBindViewHolder : 항목을 구성하기 위해 호출. 여기에서 ViewHolder가 가지고 있는 View들을 구성성

3. RecyclerView의 항목 배치

 - ListView 처럼 보여줄 것인지 GridView 처럼 보여줄 것인지 결정해야 한다.
 - LinearLayoutManager : ListView처럼 항목을 보여줌
 - GridLayoutManager : GridView 처럼 항목을 보여준다
 - StaggerGridLayoutManager : GridView처럼 보여주지만 완전한 그리드가 아닌 각 항목의 크기에 따라
                              유동적으로 조절
       }
 */