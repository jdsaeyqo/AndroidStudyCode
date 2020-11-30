package com.example.activitydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //현재 액티비티를 실행하기 위해 사용한 인텐트로부터 데이터 추출
        val data1 = intent.getIntExtra("data1",0)
        val data2 = intent.getDoubleExtra("data2",0.0)
        val data3 = intent.getBooleanExtra("data3",false)
        val data4 = intent.getStringExtra("data4") //기본값 null

        textView2.text = "data1 : $data1 \n"
        textView2.append("data2 : $data2 \n")
        textView2.append("data3 : $data3 \n")
        textView2.append("data24 : $data4")

        button2.setOnClickListener {

            val result_intent = Intent()

            result_intent.putExtra("value1",200)
            result_intent.putExtra("value2",22.22)
            result_intent.putExtra("value3",false)
            result_intent.putExtra("value4","문자열2")

            setResult(RESULT_OK,result_intent)


            finish()
        }
    }
}