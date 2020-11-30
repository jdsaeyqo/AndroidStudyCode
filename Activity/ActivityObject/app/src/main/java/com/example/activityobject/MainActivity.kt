package com.example.activityobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val second_intent = Intent(this, SecondActivity::class.java)


            val t1 = TestClass()
            t1.data1 = 100
            t1.data2 = "문자열1"

            second_intent.putExtra("obj",t1)

//            startActivity(second_intent)

            startActivityForResult(second_intent,SECOND_ACTIVITY)


        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == SECOND_ACTIVITY)
            if(resultCode== RESULT_OK){
                //객체 추출
                val obj2 = data?.getParcelableExtra<TestClass>("obj2")

                textView.text = "obj2.data2 : ${obj2?.data1}"
                textView.append("obj2.data2 : ${obj2?.data2}")
            }
    }
}