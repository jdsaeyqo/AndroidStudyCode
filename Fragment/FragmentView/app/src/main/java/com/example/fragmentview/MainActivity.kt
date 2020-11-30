package com.example.fragmentview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frag = SubFragment()
        val tran = supportFragmentManager.beginTransaction()
        tran.replace(R.id.container1,frag)
        tran.commit()
    }
}

/*
Activity 프로퍼티를 사용하면 Fragment를 소유하고 있는 Activity에 접근이 가능하다
 */