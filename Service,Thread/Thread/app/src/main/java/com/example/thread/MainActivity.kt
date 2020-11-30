package com.example.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
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

//        while (true ){
//            SystemClock.sleep(100)
//            val now2 = System.currentTimeMillis()
//            Log.d("test","while문 : $now2")
//        }



        isRunning= true
        //오래 걸리는 작업은 쓰레드 안에다 넣기
//        val thread1 = object :Thread(){
//            override fun run() {
//                super.run()
//                while (isRunning){
//                    SystemClock.sleep(100)
//                    val now2 = System.currentTimeMillis()
//                    Log.d("test","Thread: $now2")
//
//                    //8.0이상부터는 개발자가 발생시킨 쓰레드 내에서 화면 처리 가능
//                    textView2.text = "thread : $now2"
//                }
//
//
//
//            }
//        }

//        thread1.start()

        //람다 방법 - start필요 없음
        thread {
            while (isRunning){
                SystemClock.sleep(100)
                val now2 = System.currentTimeMillis()
                Log.d("test","Thread : $now2")
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}
/*
Main Thread와 사용자 Thread

안드로이드는 Activity의 코드를 처리하기 위해 Thread를 발생 시킨다.
이 때 발생시키는 Thread를 Main Thread라고 부르며 UI Thread라고 부르기도 한다
Main Thread가 현재 어떠한 처리도 하지 않고 유휴 상태일때만 화면 작업이 가능하다
이 때문에 오래 걸리는 작업은 별도의 Thread를 발생시켜 처리하고 Main Thread를 항상 유휴상태로 유지하게
해야한다

1.화면에 관련된 작업이나 터치처리는 UI Thread(Main Thread)에서만 처리 가능

2. Main Thread가 바쁘다면 화면 작업이나 터치 처리를 할수가 없다

3. 오래 걸리는 작업은 별도의 쓰레드 운영해야 한다.

화면처리

안드로이드는 개발자가 발생 시킨 Thread에서 화면에 대한 처리를 하면 오류가 발생
이 때문에 Thread운영에 대한 처리를 학습해야 한다
현재 안드로이드 오레오(8.0)이상 부터는 개발자가 발생시킨 Thread에서 화면 처리가 가능하다
허나 OS버전이 변경되면서 상황은 달라질 수도 있고 하위 버전을 위해 화면 처리는 반드시 Main Thread에서
하는 것이 좋다



 */