package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val br = TestReciever()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //8.0이상 부터는 코드를 통해 등록하고 해제해야한다
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val filter = IntentFilter("kr.co.softcampus.testbr")
            registerReceiver(br,filter)
        }

        button.setOnClickListener {
//            val brIntent = Intent(this,TestReciever::class.java)

            //안드로이드 8.0 부터는 개발자가 만든 BroadCastReceiver와 OS에서 제공하는 일부
            //BroadCastReceiver는 코드를 통해서만 등록이 가능하다
            //보안 상의 이유로 BroadCastReceiver를 가진 애플리케이션 내부에서만 사용하기 위한 제약
            val brIntent = Intent("kr.co.softcampus.testbr")
            sendBroadcast(brIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
           unregisterReceiver(br)
        }
    }
}
/*
BroadCastReceiver는 안드로이드 OS에서 특정 상황에 발생하는 메시지를 받아들여 동작하는 실행단위

BroadCastReceiver는 반드시 외부에서 접근을 하기위한 이름을 가져야 한다

실제 동작은 애플리케이션이 단말기에 설치되면 안드로이드 OS는 BroadCastReceiver에 등록된 이름으로
정리하여 목록화한다.

안드로이드OS에서 어떤 사건이 발생하면 사건과 관련된 이름으로 지정된 BroadCastReceiver를 찾아 동작 시킨다

또 애플리케이션에서 이름을 전달하여 실행을 요청하면 해당 이름이 지정된 BroadCastReceiver를 찾아 동작시킨다

BroadCastReciever의 이름
- BroadCastReceiver는 평소에는 동작하지 않다가 동작 요청이 발생하면 동작하게 된다
- 이 때, 동작 요청은 이름을 통해 요청할 수 있으며 intent filter를 통해 이름을 등록한다
 */