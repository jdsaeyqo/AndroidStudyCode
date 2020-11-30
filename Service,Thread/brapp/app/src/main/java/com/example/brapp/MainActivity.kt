package com.example.brapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
        val brIntent = Intent("kr.co.softcampus.testbr")
            sendBroadcast(brIntent)
        }

        /*
        8.0 이상부터는  코드를 통해서 BroadCastReceiver를 등록해야지만 다른 어플리케이션이
        리시버를 사용할 수 있다.
         */
    }
}