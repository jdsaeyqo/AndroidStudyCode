package com.example.applicationclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val app = application as AppClass

        textView2.text = "value1 : ${app.value1}\n"
        textView2.append("value2 : ${app.value2}")

        button2.setOnClickListener {
            
            app.value1 =200
            app.value2 = "반갑습니다"
            finish()
        }
    }
}