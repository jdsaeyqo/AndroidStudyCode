package com.example.activitydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    val SECOND_ACTIVITY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val second_intent = Intent(this,SecondActivity::class.java)

            second_intent.putExtra("data1",100)
            second_intent.putExtra("data2",11.11)
            second_intent.putExtra("data3",true)
            second_intent.putExtra("data4","문자열1")



           startActivityForResult(second_intent,SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == SECOND_ACTIVITY){
            if(resultCode == RESULT_OK){
                val value1 = data?.getIntExtra("value1",0)
                val value2 = data?.getDoubleExtra("value2",0.0)
                val value3 = data?.getBooleanExtra("value3",false)
                val value4 = data?.getStringExtra("value4")

                textView.text = "value : $value1 \n"
                textView.append("value : $value2 \n")
                textView.append("value : $value3 \n")
                textView.append("value : $value4 \n")
            }
        }
    }
}