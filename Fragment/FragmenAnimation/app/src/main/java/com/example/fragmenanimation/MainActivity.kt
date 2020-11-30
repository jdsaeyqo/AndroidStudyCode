package com.example.fragmenanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    val firstFragment = FirstFrag()
    val secondFragment = SecondFrag()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment("first")
    }

    fun setFragment(name : String){
        val tran = supportFragmentManager.beginTransaction()

        when(name){
            "first" ->{
                tran.replace(R.id.container1,firstFragment)

            }
            "second" -> {
               // tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                //tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                //tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)

                //tran.setCustomAnimations(R.anim.fade_xml1, R.anim.fade_xml2,R.anim.fade_xml1,R.anim.fade_xml2)
                tran.setCustomAnimations(R.anim.slide_xml1, R.anim.slide_xml2,R.anim.slide_xml3,R.anim.slide_xml4)

                tran.replace(R.id.container1,secondFragment)
                tran.addToBackStack(null)
            }
        }
        tran.commit()

    }
}
/*
새로운 Fragment를 표시할 때 애니메이션을 설정할 수 있다
애니메이션은 미리 정의되어 있는 것이 있고 직접 구성할 수도 있다
주의할 점은 애니메이션 설정은 프래그먼트를 교체하지 전에 해야한다
기본 애니메이션은 관계가 없지만 애니메이션을 커스터마이징 할 경우 프래그먼트 교체 후
설정하면 애니메이션이 적용되지 않는다.

기본 애니메이션
setTransition : 애니메이션을 설정하는 메서드. 새로운 Fragment로 교체할 때 설정하며 돌아올 때도
                애니메이션이 나타난다
                
TRANSIT_FRAGMENT_FADE , TRANSIT_FRAGMENT_OPEN, TRANSIT_FRAGMENT_CLOSE 3가지를 제공하고 있으며
안드로이드 버전에 따라 모두 같은 애니메이션이 나타날 수도 있다

애니메이션 커스터마이징
개발자가 xml 파일을 통해 애니메이션을 커스터마이징 할 수 있다
나타나는 프래그먼트의 애니메이션, 사라지는 프래그먼트의 애니메이션, 이전 프래그먼트로 돌아올 때
나타나는 프래그먼트의 애니메이션, 이전 프래그먼트로 돌아올 때 사라지는 프래그먼트의 애니메이션
총 4가지를 정의해야한다
 */