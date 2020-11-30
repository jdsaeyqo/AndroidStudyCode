package com.example.onacitivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val SecondActivity = 1
    val thirdActivity = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val second_intent = Intent(this,SecondActivity::class.java)
            startActivityForResult(second_intent,SecondActivity)
        }

        button4.setOnClickListener {
            val Third_intent = Intent(this,ThirdActivity::class.java)
            startActivityForResult(Third_intent,thirdActivity)
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        textView.text = "다른 Activity에서 돌아왔습니다"

        when(requestCode){
            SecondActivity -> {
                textView.text = "SecondActivity에서 돌아왔습니다"
            }
            thirdActivity -> {
                textView.text = "ThirdActivity에서 돌아왔습니다\n"
                when(resultCode){
                    Activity.RESULT_OK -> {
                        textView.append("결과 : OK")
                    }
                    Activity.RESULT_CANCELED -> {
                        textView.append("결과 : CANCEL")

                    }Activity.RESULT_FIRST_USER -> {
                    textView.append("결과 : USER1")


                }Activity.RESULT_FIRST_USER + 1 -> {
                    textView.append("결과 : USER2")


                }
                }
            }
        }
    }
}