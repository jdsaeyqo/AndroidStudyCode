package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //ViewPager를 통해 보여줄 View들을 담을 리스트
    val viewList = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view1 = layoutInflater.inflate(R.layout.view1, null)
        val view2 = layoutInflater.inflate(R.layout.view2, null)
        val view3 = layoutInflater.inflate(R.layout.view3, null)
        val view4 = layoutInflater.inflate(R.layout.view1, null)
        val view5 = layoutInflater.inflate(R.layout.view2, null)
        val view6 = layoutInflater.inflate(R.layout.view3, null)

        viewList.add(view1)
        viewList.add(view2)
        viewList.add(view3)
        viewList.add(view4)
        viewList.add(view5)
        viewList.add(view6)

        val adapter1 = object : PagerAdapter() {
            //ViewPager가 보여줄 View의 개수
            override fun getCount(): Int {
                return viewList.size
            }

            //ViewPager가 보여줄 화면 View를 반환하는 메서드
            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                pager1.addView(viewList[position])
                return viewList[position]
            }

            //instantiateItem이 반환한 객체를 화면으로 사용할 것인가를 검사하는 메서드
            override fun isViewFromObject(view: View, obj: Any): Boolean {
                return view == obj
            }

            override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
                pager1.removeView(obj as View)
            }


        }

        pager1.adapter = adapter1



        val listener1 = object : ViewPager.OnPageChangeListener {

            //페이지의 스크롤 상태가 변경되었을 때
            override fun onPageScrolled(
                position: Int, positionOffset: Float, positionOffsetPixels: Int
            ) {


            }

            //페이지의 스크롤이 끝났을 때 호출되는 메서드
            override fun onPageSelected(position: Int) {
                textView.text = "${position+1} 번째 View가 나타났습니다"

            }

            //페이지를 선택했을 때 호출되는 메서드
            override fun onPageScrollStateChanged(state: Int) {

            }


        }
        pager1.addOnPageChangeListener(listener1)


    }
}
/*
ViewPager
- 좌우로 스와프하면서 View를 전환하는 AdapterView이다
- 화면이 바뀌는 것이 아닌 화면의 크기만한 View들을 생성하여 View들을 전환하는 개념
- 현재 ViewPager를 업그레이드한 ViewPager2를 제공하고 있다
- ViewPager는 View를 전환할때, ViewPager2는 프래그먼트라는 것을 전환할 때 사용

ViewPager 구형
- ViewPager는 PagerAdapter를 구현하여 사용. PagerAdapter에서는 다음 메서드 구현

-getCount : ViewPager로 보여줄 View의 전체 개수
-instantiateItem : ViewPager로 보여줄 View 객체를 생성
-isViewFromObject : instantiateItem에서 만든 객체를 사용할 것인지의 여부를 결정
-destroyItem : ViewPager에서 View가 사라질 때 제거하는 작업을 한다\

주요 이벤트
PageChange : ViewPager에서 View가 전환될 때 반응하는 리스너

 */