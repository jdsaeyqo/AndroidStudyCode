package com.example.activityanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button2.setOnClickListener {
            finishActivity()
        }
    }

    //back 버튼을 누르면 호출되는 메서드

    override fun onBackPressed() {
        finishActivity()
    }

    fun finishActivity(){
        finish()
//        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
//         overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
         overridePendingTransition(R.anim.slide_xml3,R.anim.slide_xml4)


    }
}