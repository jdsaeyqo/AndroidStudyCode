package com.example.applicationclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {

            var app = application as AppClass
            app.method1()
            app.value1  = 100
            app.value2 = "안녕하세요"

            val secondIntent = Intent(this,SecondActivity::class.java)
            startActivityForResult(secondIntent,0)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val app = application as AppClass
        textView2.text = "value1 : ${app.value1}\n"
        textView2.append("value2 : ${app.value2}")
    }
}