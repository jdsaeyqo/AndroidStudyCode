package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val frag1 = FirstFragment()
        val frag2 = SecondFragment()

        button.setOnClickListener {
            // Fragment 작업 시작
            val tran = supportFragmentManager.beginTransaction()
            //Fragment를 세팅
            //tran.add(R.id.container1,frag1)
            tran.replace(R.id.container1,frag1)
            tran.addToBackStack(null)
            tran.commit()
        }

        button2.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container1,frag2)
            tran.addToBackStack(null)
            tran.commit()
        }



    }
}
/*
여러 화면을 가지고 있는 애플리케이션은 여러 Activity를 가지고 있는 애플리케이션을 의미한다

Activity는 독립된 실행단위로 메모리를 많이 소모하는데 독립된 실행단위가 아닌 화면만 필요한 경우
Activity 보다는 Fragment를 활용하는 것이 효율적이다

Fragment는 Activity내의 작은 화면 조각으로 Activity의 화면을 여러 영역으로 나누어 관리하고 하는
목적으로 사용한다.

add : Fragment를 지정된 레이아웃에 추가한다
replace : 지정된 레이아웃에 설정되어 있는 Fragment를 제거하고 새로운 Fragment를 추가


AddToBackStack

안드로이드에서 back button은 현재 Activity를 종료한다

Fragment는 Activity가 아니므로 Back Button으로 제거할 수 없는데 AddToBackStack메서드를 통해
BackStack에 포함한 경우 Back Button으로 제거할 수 있다

이를 통해서 마지 이전화면으로 돌아가는 듯한 효과를 줄 수 있다
 */