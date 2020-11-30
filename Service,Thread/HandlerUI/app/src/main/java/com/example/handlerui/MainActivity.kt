package com.example.handlerui

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val now = System.currentTimeMillis()
            textView.text = "버튼 클릭 : $now"
        }

        //화면 처리를 위한 핸들러
        val handler1 = object : Handler(Looper.myLooper()!!){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                 when(msg.what){
                     0 -> {textView2.text = "handler 0"}
                     1 -> {textView2.text = "handler 1"}
                     2 -> {textView2.text = "handler 2 : ${msg.arg1}, ${msg.arg2}, ${msg.obj}"}
                 }

//                //메인 쓰레드에서 처리
//                val now3 = System.currentTimeMillis()
//                textView2.text = "핸들러 : $now3"
            }
        }

        //오래 걸리는 작업
        isRunning = true
        thread {
            while (isRunning){
                val now2 = System.currentTimeMillis()
                Log.d("test","오래 걸리는 작업 : $now2")

                SystemClock.sleep(500)

                handler1.sendEmptyMessage(0)

                SystemClock.sleep(500)
                handler1.sendEmptyMessage(1)

                SystemClock.sleep(500)

                val msg = Message()
                msg.what = 2
                msg.arg1 = 100
                msg.arg2 = 200
                msg.obj = "객체"
                handler1.sendMessage(msg)
            }
        }


    }

    override fun onDestroy() {
            super.onDestroy()
        isRunning = false
    }
}


/*
안드로이드에서 네트워크 관련된 처리나 오래 걸리는 작업은 모두 개발자가 발생하는 쓰레드에서 처리해야한다

안드로이드 8.0미만 OS에서는 개발자가 발생하는 쓰레드에서 화면에 관한 처리를 하면 오류가 발생
이 때 Handler를 이용하면 화면 처리가 가능하다.
 */