package com.example.socketnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
/*
안드로이드 네트워크 기능을 구현할 때 소켓 네트워크와 Http 네트워크 등을 사용할
수 있다

안드로이드 네트워크 구현 시 INTERNET 권한을 등록해야 한다

네트워크와 관련된 코드는 쓰레드로 운영해야 한다.
 */