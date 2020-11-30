package com.example.toast

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        button.setOnClickListener {
            //토스트 객체를 생성
            val t1 = Toast.makeText(this, "기본 Toast",Toast.LENGTH_SHORT)

            //callback 객체 생성
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R ){
            val callback = object :Toast.Callback(){
                override fun onToastHidden() {
                    super.onToastHidden()
                    textView.text = "Toast메시지가 사라졌습니다"
                }

                override fun onToastShown() {
                    super.onToastShown()
                    textView.text = "Toast메시지가 나타났습니다"
                }
            }

                t1.addCallback(callback)



            }
            t1.show()
        }

        button2.setOnClickListener {
            //Toast에 보여줄 View를 생성
            val toastView = layoutInflater.inflate(R.layout.custom_toast,null)

            toastView.run {
                toast_image.setImageResource(R.drawable.img_android)
                toast_text.text = "Custom Toast 입니다"
            }

            toastView.setBackgroundResource(android.R.drawable.toast_frame)

            //Toast객체를 생성
            val t2 = Toast(this)
            t2.view = toastView  //view 대신 SnackBar쓰는거 추천

            t2.setGravity(Gravity.CENTER,0,0)   //위치 설정,  x,y좌표 설정 가능

            t2.duration = Toast.LENGTH_LONG


           t2.show()
        }


    }
}
    /*
    안드로이드는 사용자에게 메시지를 전달할 수 있는 다양한 방법을 제공한다
    Toast : 일정 시간이 지나면 자동으로 사라지는 메시지
    Dialog : Activity위에 나타나는 메시지
    Notification : 알림창에 표시되는 메시지
    메시지의 일부는 Activity, Service와 관련이 있다

    Toast
    안드로이드에서 간단하게 메시지를 표시할 때 사용한다
    화면과 관련 없이 안드로이드 OS에게 메시지 출력을 요청하고
    안드로이드 OS에 의해 나타나는 메시지
    단말기 내의 모든 애플리케이션, 모든 구성요소가 요청할 수 있으며 애플리케이션에
    관계없이 요청된 순서대로 메시지가 나타난다

    주요 메서드,프로퍼티
    makeText : Toast 메시지 객체를 만든다. 화면 모양, 글자 크기 및 색상 등은 기본 설정되어 있는
               것을 사용
    setGravity : Toast 메시지가 표시될 위치를 설정
    view : Toast 메시지를 통해 보여줄 View를 설정. 이를 이용해 커스터마이징 가능
           view 프로퍼티를 이용해 Toast를 커스터 마이징 하는 것은 안드로이드 11(API30) 부터
           Deprecated되었다. 이 후에는 SnackBar를 사용하는 것을 추천
    Duration : 메시지가 표시된 시간을 설정

    Callback
    안드로이드 11(API30) 부터 Toast에 Callback을 설정할 수 있다
    - onToastHidden : Toast 메시지가 사라질 때 호출
    - onToastShown : Toast 메시지가 나타날 때 호출



    */
