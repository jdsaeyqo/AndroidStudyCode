package com.example.tablayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
//뷰페이저를 사용하기 위해서는 FragmentActivity를 사용해야함
class MainActivity : FragmentActivity() {

    //ViewPager2에 세팅하기 위한 Fragment들을 가지고 있는 ArrayList

    val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setActionBar(toolbar)

        toolbar.setTitleTextColor(Color.WHITE)

        //선택안됬을 때 색, 선택 됬을 때 색
        tabs.setTabTextColors(Color.WHITE, Color.RED)

        for (i in 0..9) {
            val sub = SubFragment("$i 번째 프래그먼트")
            fragmentList.add(sub)
        }

        val adapter1 = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragmentList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }

        }

        pager2.adapter = adapter1

        //tab과 viewapager를 연결한다
        TabLayoutMediator(tabs,pager2){tab,position ->
            tab.text = "탭 $position"


        }.attach()


    }
}