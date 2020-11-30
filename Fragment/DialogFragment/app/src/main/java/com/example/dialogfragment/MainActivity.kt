package com.example.dialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val subFragment = SubFragment()
            subFragment.show(supportFragmentManager,"tag")
        }


    }
}
/*
AlertDialog를 Fragment로 만들어 사용할 수 있도록 제공되는 Fragment
AlertDialog와 큰 차이는 없다
DialogFragment도 Fragment이므로 Fragment의 생명주기나 기타 다양한 기능들을 그대로 사용할 수 있다

 */