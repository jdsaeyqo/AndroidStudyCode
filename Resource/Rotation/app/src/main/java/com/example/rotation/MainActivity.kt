package com.example.rotation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     if(savedInstanceState == null){
         Log.d("test","Activity가 처음 등장")
    }else{
         Log.d("test","화면회전이 발생")
         //복원
         textView.text = savedInstanceState.getString("data1")
     }

        button.setOnClickListener {
            textView.text = editTextTextPersonName.text
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //복원에 필요한 데이터를 저장
        outState.putString("data1",textView.text.toString())
    }
}