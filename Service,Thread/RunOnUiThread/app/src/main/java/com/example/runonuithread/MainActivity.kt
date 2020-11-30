package com.example.runonuithread

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

        isRunning = true
        thread {
            while (isRunning){
                SystemClock.sleep(500)

                val now2 = System.currentTimeMillis()
                Log.d("test","thread : $now2")

//                runOnUiThread(object  : Thread(){
//                    override fun run() {
//                        super.run()
//                        textView2.text = "runOnUiThread : $now2"
//                    }
//                })
                //람다식 지원
                runOnUiThread {
                    textView2.text = "runOnUiThread : $now2"
                }

                SystemClock.sleep(500)

//                runOnUiThread(object  : Thread(){
//                    override fun run() {
//                        super.run()
//                        textView2.text = "또다른 작업"
//                    }
//                })

                runOnUiThread {
                    textView2.text = "또다른 작업"
                }


            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning =false
    }
}