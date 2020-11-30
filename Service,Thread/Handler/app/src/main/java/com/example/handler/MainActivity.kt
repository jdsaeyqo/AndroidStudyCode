package com.example.handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val now = System.currentTimeMillis()
            textView.text = "버튼 클릭 : $now"
        }

//        //무한 작업을 하므로 메인쓰레드에서 화면처리 불가
//        while(true) {
//            SystemClock.sleep(100) //쉬는 것도 작업이므로 영향 없음
//            val now2 = System.currentTimeMillis()
//            textView2.text = "while문 : $now2 "
//        }


        val handler = Handler(Looper.myLooper()!!)

        //처리 한번에 대한 작업을 구현해준다.
        val thread1 = object :Thread(){
            override fun run() {
                super.run()
                val now2 = System.currentTimeMillis()
                textView2.text = "handler : $now2"

                handler.postDelayed(this,100)
            }
        }

        //handler.post(thread1)
        handler.postDelayed(thread1,100)


    }
}
/*
Handler

Handler는 개발자가 안드로이드 OS에게 작업 수행을 요청하는 역할을 한다

개발자가 작업을 요청하면 안드로이드 OS는 작업을 하지 않을 때 개발자가 요청한 작업을 처리하게 된다

이 처리는 Main Thread에서 처리한다
5초 이상 걸리는 작업은 피하는 것이 좋다

화면처리도 가능
 */